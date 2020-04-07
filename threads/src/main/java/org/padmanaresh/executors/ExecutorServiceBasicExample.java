package org.padmanaresh.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceBasicExample {
    public static void main(String[] args) throws Exception{
        System.out.println("Created Thread pool");
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<String> returnedFuture = pool.submit(() -> {
            System.out.println("Callable task started..");
            System.out.println("processing taking time ..");
            TimeUnit.SECONDS.sleep(20);
            System.out.println("Callable task completed");
            return "returned value";
        });
        System.out.println("Shutting down executor");
        pool.shutdown();
        System.out.println("awaiting for termination");
        pool.awaitTermination(1,TimeUnit.MINUTES);
        System.out.println("is shut down completed " +pool.isShutdown());
        System.out.println("is termination completed " +pool.isTerminated());
        System.out.println("Getting value from future");
        String val = returnedFuture.get();
        System.out.println(val);
        System.out.println("is shut down completed " +pool.isShutdown());
        System.out.println("is termination completed " +pool.isTerminated());
    }

}
