package org.padmanaresh.completablefeature.examples;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureCombineExample {

    public static void main(String[] args) throws Exception{
    CompletableFuture<Integer> integerCompletableFuture = getCompletableFuture1(1).thenCombine(getCompletableFuture1(2), (a, b) -> a + b);
        System.out.println(integerCompletableFuture);
        integerCompletableFuture.thenAccept(System.out::println);
        TimeUnit.SECONDS.sleep(2);
        System.out.println(integerCompletableFuture);
    }

    private static CompletableFuture<Integer> getCompletableFuture1(int i){
        return CompletableFuture.supplyAsync( () -> {
            System.out.println(Thread.currentThread().getName());
            return i*i;
        });
    }
}
