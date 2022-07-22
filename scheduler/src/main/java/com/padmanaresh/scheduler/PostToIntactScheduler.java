package com.padmanaresh.scheduler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PostToIntactScheduler {

    ApplicationEventMulticaster multiCaster;

    public PostToIntactScheduler(ApplicationEventMulticaster multiCaster) {
        this.multiCaster = multiCaster;
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void triggerSchedulerEvent(){
       // System.out.println("Triggering Event every five seconds");
        multiCaster.multicastEvent(new PostToIntacctEvent("source", String.valueOf(new Random().nextInt(100))));
       // System.out.println("Event Triggered");
    }

}






