package com.padmanaresh.scheduler;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PushToIntacctTask implements Runnable{

    private Integer identifier;

    public PushToIntacctTask(Integer identifier) {
        this.identifier = identifier;
    }

    @Override
    public void run() {
            System.out.println("Processing batch of size " + identifier);
            IntStream.rangeClosed(0, identifier).forEach(value ->{
                try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            });
    }
}
