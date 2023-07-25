package com.gubin.api.config.threadpool;

import java.util.concurrent.*;

public class MyThreadPoolExecutor {
    public static ExecutorService newFixedThreadPool(int corePoolsize, int maximumPoolsize, int blockingQueue) {
        return new ThreadPoolExecutor(corePoolsize, maximumPoolsize,
                60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(blockingQueue), (RejectedExecutionHandler) new ThreadPoolExecutionHandler());

    }
}
