package com.gubin.api.config.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutionHandler implements ThreadFactory, RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义拒绝任务");
    }

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
