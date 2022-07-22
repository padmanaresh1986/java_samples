package com.padmanaresh.scheduler;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.stream.IntStream;

@Component
public class PostToIntacctEventListner implements ApplicationListener<PostToIntacctEvent> {

    @Override
    public void onApplicationEvent(PostToIntacctEvent event) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Integer size = Integer.valueOf(event.getIdentifier());
        try {
            System.out.println("Triggering thread for size "+ size);
            Future future = executor.submit(new PushToIntacctTask(size));
            future.get(50, TimeUnit.SECONDS);
           // Runnable cancelTask = () -> future.cancel(true);
           // executor.schedule(cancelTask, 1, TimeUnit.SECONDS);
           // System.out.println("Cancelled "+future.isCancelled());
        } catch(TimeoutException timeoutException){
            System.err.println("Processing failed Due to Timeout exception for size" + size);
        }catch (Exception e) {
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
