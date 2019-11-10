package com.zping.lib_thinking_in_java.t21_concurrency;//: concurrency/CachedThreadPool.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        System.out.println("i am done!!!");
        for (int i = 0; i < 2; i++) {
            exec.execute(new LiftOff());
        }
    }
} /*
#0(9), #1(9), i am done!!!
Exception in thread "main" java.util.concurrent.RejectedExecutionException:
Task com.zping.lib_thinking_in_java.t21_concurrency.LiftOff@75828a0f
rejected from java.util.concurrent.ThreadPoolExecutor@3abfe836
[Shutting down, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 0]
	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
	at com.zping.lib_thinking_in_java.t21_concurrency.CachedThreadPool.main(CachedThreadPool.java:15)
#0(8), #1(8), #0(7), #1(7), #0(6), #1(6), #0(5), #1(5), #0(4), #1(4), #0(3), #1(3), #0(2), #1(2),
#0(1), #1(1), #0(Liftoff!), #1(Liftoff!)
*///:~
