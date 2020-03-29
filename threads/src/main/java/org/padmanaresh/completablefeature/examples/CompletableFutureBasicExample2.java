package org.padmanaresh.completablefeature.examples;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureBasicExample2 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        var future1 = new CompletableFuture<Integer>();
        buildPipeline(future);
        future.complete(4);
        buildPipeline(future1);
        future1.complete(5);
    }

    /**
     * build pipeline in separate method and use it anywhere
     * @param future
     */
    private static void buildPipeline(CompletableFuture<Integer> future){
         future.thenApply( val -> val* 20)
                .thenAccept(System.out::println);
    }

}
