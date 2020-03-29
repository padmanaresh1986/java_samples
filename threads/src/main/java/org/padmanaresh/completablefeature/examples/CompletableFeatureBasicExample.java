package org.padmanaresh.completablefeature.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFeatureBasicExample {

    public static void main(String[] args) throws Exception {
        System.out.println("main thread started ...");
        System.out.println("spawn new thread for network process  ...");
        /**
         * use supplyAsync when thread returns some value , else runAsync
         */

        CompletableFuture.supplyAsync(() -> longNetworkProcess(2))
                .thenApply(val -> processValue(val))
                .thenApply(val -> processValue(val))
                .thenAccept( result -> System.out.println( "Network Process replied with val " + result));
        // int j = longNetworkProcess(2);
        //System.out.println(j);
        System.out.println("meanwhile main thread doing some other job");
        TimeUnit.SECONDS.sleep(6);
        System.out.println("done ....");
    }
    private static int longNetworkProcess(int i){
        System.out.println("network process happening in separate thread "+ Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i * i ;
    }

    private static int processValue(int i){
        System.out.println("process value in thread " + Thread.currentThread().getName());
        if(i%2 == 0){
            i = i+3;
        }else{
            i = i+4;
        }
        return i;
    }



}
