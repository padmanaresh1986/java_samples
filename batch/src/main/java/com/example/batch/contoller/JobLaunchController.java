package com.example.batch.contoller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLaunchController {
    JobLauncher jobLauncher;
    Job firstAsyncJob;

    public JobLaunchController(JobLauncher jobLauncher,Job firstAsyncJob) {
        this.jobLauncher = jobLauncher;
        this.firstAsyncJob = firstAsyncJob;
    }

    @GetMapping("/launch")
    public String launchJob() throws Exception{
        jobLauncher.run(firstAsyncJob,new JobParameters());
        return "Launched";
    }
}
