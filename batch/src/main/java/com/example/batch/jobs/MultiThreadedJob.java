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
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableBatchProcessing
public class MultiThreadedJob {

    JobBuilderFactory  jobBuilderFactory;
    StepBuilderFactory stepBuilderFactory;

    public MultiThreadedJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @Bean
    Job firstMultiThreadJob(){
        return jobBuilderFactory.get("Multi Threaded Job")
                .incrementer(new RunIdIncrementer())
                .listener(getListener())
                .flow(multiThreadStep())
                .end().build();
    }

    @Bean
    @JobScope
    JobExecutionListener getListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                System.out.println("Multithread Job Started");
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                System.out.println("Multithread Job Completed");
            }
        };
    }

    @Bean
    @JobScope
    Step multiThreadStep() {
        return stepBuilderFactory.get("Multi Threaded Step")
                .<Integer,Integer>chunk(1)
                .reader(getReader())
                .processor(getProcessor())
                .writer(getWriter())
                .taskExecutor(taskExecutor())
                .build();
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
                TimeUnit.SECONDS.sleep(5);
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
                list.forEach( it ->
                         System.out.println(Thread.currentThread().getName() +" : " + it));
            }
        };
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(64);
        executor.setMaxPoolSize(64);
        executor.setQueueCapacity(64);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("MultiThreaded-");
        return executor;
    }
}

