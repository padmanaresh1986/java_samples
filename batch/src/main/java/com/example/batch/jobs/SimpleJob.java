package com.example.batch.jobs;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableBatchProcessing
public class SimpleJob {

    JobBuilderFactory  jobBuilderFactory;
    StepBuilderFactory stepBuilderFactory;

    public SimpleJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @Bean
    Job firstSimpleJob(){
        return jobBuilderFactory.get("Simple Job")
                .incrementer(new RunIdIncrementer())
                .listener(getListener())
                .flow(simpleStep())
                .end().build();
    }

    @Bean
    @JobScope
    JobExecutionListener getListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                System.out.println("Simple Job Started");
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                System.out.println("Simple Job Completed");
            }
        };
    }

    @Bean
    @JobScope
    Step simpleStep() {
        return stepBuilderFactory.get("Simple Step")
                .<Integer,Integer>chunk(1)
                .reader(getReader())
                .processor(getProcessor())
                .writer(getWriter()).build();
    }

    @Bean
    @StepScope
    ItemReader<Integer> getReader() {
        return new ItemReader<Integer>() {
            @Override
            public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                return 2;
            }
        };
    }

    @Bean
    @StepScope
    ItemProcessor<Integer, Integer> getProcessor() {
        return new ItemProcessor<Integer, Integer>() {
            @Override
            public Integer process(Integer integer) throws Exception {
                return integer+10;
            }
        };
    }

    @Bean
    @StepScope
    ItemWriter<Integer> getWriter() {
        return new ItemWriter<Integer>() {

            @Override
            public void write(List<? extends Integer> list) throws Exception {
                list.forEach(System.out::println);
            }
        };
    }
}

