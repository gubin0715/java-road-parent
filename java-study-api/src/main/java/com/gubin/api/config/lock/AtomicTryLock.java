package com.gubin.api.config.lock;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicTryLock {

    private AtomicLong atomicLong = new AtomicLong(0);

    private Thread lockCurrentThread = new Thread();

    public boolean tryLock() {
        while (true) {
            boolean result = atomicLong.compareAndSet(0, 1);
            if (result) {
                lockCurrentThread = Thread.currentThread();
            }
            return result;
        }
    }

    public boolean unLock() {
        boolean result = atomicLong.compareAndSet(1, 0);
        if (result && lockCurrentThread.equals(Thread.currentThread())) {
            return true;
        }
        return false;
    }

}
