package org.padmanaresh.completablefeature.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureAllOfExample {

    public static void main(String[] args) throws Exception{
        List<String> langList = Arrays.asList("EN", "ES", "SN", "EX");
        //Executor executor = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<CompletableFuture<GreetHolder>> completableFutures =
                langList.stream().map(lang -> getGreeting(lang,pool)).collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));

        CompletableFuture<List<GreetHolder>> allCompletableFuture = allFutures.thenApply(future -> {
            return completableFutures.stream()
                    .map(completableFuture -> completableFuture.join())
                    .collect(Collectors.toList());
        });

        CompletableFuture<List<String>> completableFuture = allCompletableFuture.thenApply(greets -> {
            return greets.stream().filter(Objects::nonNull).map(GreetHolder::greet)
                    .collect(Collectors.toList());
        });

        List<String> greets = completableFuture.get();
        System.out.println(greets);
        pool.shutdown();
        pool.awaitTermination(2,TimeUnit.MINUTES);

    }

    private static String getGreet(String lang) {
        if (lang.equals("EN")) {
            return "Hello";
        } else if (lang.equals("ES")) {
            return "Hola";
        } else if (lang.equals("SN")) {
            return "Ayubovan";
        } else {
            throw new IllegalArgumentException("Invalid lang param");
        }
    }

    private static CompletableFuture<GreetHolder> getGreeting(String lang,ExecutorService executor) {
         return CompletableFuture.supplyAsync( () -> {
            try {
                System.out.println("Task execution started."+Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("Task execution stopped.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new GreetHolder(getGreet(lang));
        },executor).exceptionally( e -> {
             System.out.println(e.getCause());
            //e.printStackTrace();
            return null;
        });

    }

    private record  GreetHolder(String greet){}
}
