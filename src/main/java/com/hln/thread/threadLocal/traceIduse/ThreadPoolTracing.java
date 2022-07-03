package com.hln.thread.threadLocal.traceIduse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolTracing {

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTracing.class);
    public static ThreadLocal<String>  threadLocalTraceId = new ThreadLocal<>();

    static class Task implements Runnable {

        @Override
        public void run() {
            String traceId=threadLocalTraceId.get();
            logger.info(" tracing traceId={}",traceId);
        }
    }
}
