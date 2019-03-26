package com.gubin.common.idwork;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SnowflakeIdWorkerLock {
    // 按照清分系统现在的id生成速度，2016-10-01之前，最大id小于1609040000000。
    // 时间戳1473000000000对应北京时间2016-9-4 22:40:00
    // twepoch = 1609040000000 - 1473000000000 = 136040000000，所以 2016-9-4以后的时间戳 + 136040000000 肯定大于 1609040000000，只要在2016-10-01之前上线服务，生成的id就不会与目前库中id冲突。
    private final long twepoch = 136040000000L;
    // 机器编号，十进制两位，0-99
    private final int workerIdBits = 2;
    private final int maxWorkerId = 99;
    // 毫秒内序列号
    private final int sequenceBits = 1;
    private final int sequenceMask = 10;
    // 数据库表尾号0-999，共3位
    private final int tableIndexBits = 3;
    // 十进制偏移量
    private final int sequenceShift = tableIndexBits;
    private final int workerIdShift = sequenceBits + tableIndexBits;
    private final int timestampLeftShift = workerIdBits + sequenceBits + tableIndexBits;

    private final Random random = new Random();

    private int workerId;
    private int sequence = 0;
    private long lastTimestamp = -1L;

    private Lock lock = new ReentrantLock();

    public SnowflakeIdWorkerLock(int workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
    }

    public long nextId() {
        lock.lock();

        // 偏移的倍数
        long timestampShiftValue;
        long workerShiftValue;
        long sequenceShiftValue;
        // 随机获取数据库表尾号
        int tableIndex;
        long timestamp = timeGen();
        try {
            if (timestamp < lastTimestamp) {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
            }
            if (lastTimestamp == timestamp) {
                sequence = (sequence + 1) % sequenceMask;
                if (sequence == 0) {
                    timestamp = tilNextMillis(lastTimestamp);
                }
            } else {
                sequence = 0;
            }

            lastTimestamp = timestamp;

            timestampShiftValue = new Double(Math.pow(10, timestampLeftShift)).longValue();
            workerShiftValue = new Double(Math.pow(10, workerIdShift)).longValue();
            sequenceShiftValue = new Double(Math.pow(10, sequenceShift)).longValue();

            tableIndex = random.nextInt(1000);
        } finally {
            lock.unlock();
        }

        return (timestamp + twepoch) * timestampShiftValue + workerId * workerShiftValue + sequence * sequenceShiftValue + tableIndex;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis() / 10;
    }
}
