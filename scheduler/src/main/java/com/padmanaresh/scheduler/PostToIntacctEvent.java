package com.padmanaresh.scheduler;

import org.springframework.context.ApplicationEvent;

public class PostToIntacctEvent extends ApplicationEvent {

    private String identifier;

    public PostToIntacctEvent(String source , String identifier) {
        super(source);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "PostToIntacctEvent{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
