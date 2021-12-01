package com.example.batch.jobs;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableBatchProcessing
public class AsyncJob {

    JobBuilderFactory  jobBuilderFactory;
    StepBuilderFactory stepBuilderFactory;

    public AsyncJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @Bean
    Job firstAsyncJob(){
        return jobBuilderFactory.get("Async Job")
                .incrementer(new RunIdIncrementer())
                .listener(getListener())
                .flow(asyncStep())
                .end().build();
    }

    @Bean
    @JobScope
    JobExecutionListener getListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                System.out.println("Async Job Started");
            }

            @Override
            public void afterJob(JobExecution jobExecution) {
                System.out.println("Async Job Completed");
            }
        };
    }

    @Bean
    @JobScope
    Step asyncStep() {
        return stepBuilderFactory.get("Async  Step")
                .<Integer, Future<Integer>>chunk(1)
                .reader(getReader())
                .processor(asyncProcessor())
                .writer(asyncWriter())
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
    public AsyncItemProcessor<Integer, Integer> asyncProcessor() {
        AsyncItemProcessor<Integer, Integer> asyncItemProcessor = new AsyncItemProcessor<>();
        asyncItemProcessor.setDelegate(getProcessor());
        asyncItemProcessor.setTaskExecutor(taskExecutor());
        return asyncItemProcessor;
    }

    @Bean
    public AsyncItemWriter<Integer> asyncWriter() {
        AsyncItemWriter<Integer> asyncItemWriter = new AsyncItemWriter<>();
        asyncItemWriter.setDelegate(getWriter());
        return asyncItemWriter;
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
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadNamePrefix("Thread-");
        return executor;
    }
}
