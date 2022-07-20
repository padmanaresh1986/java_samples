package com.padmanaresh.scheduler;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Component
public class PostToIntacctEventListner implements ApplicationListener<PostToIntacctEvent> {

    @Override
    public void onApplicationEvent(PostToIntacctEvent event) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        try {
            Integer size = Integer.valueOf(event.getIdentifier());
            System.out.println("Triggering thread for size "+ size);
            Future future = executor.submit(new PushToIntacctTask(size));
            Runnable cancelTask = () -> future.cancel(true);
            executor.schedule(cancelTask, 30, TimeUnit.SECONDS);
            System.out.println("Cancelled "+future.isCancelled());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                executor.shutdown();
                executor.awaitTermination(5,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
