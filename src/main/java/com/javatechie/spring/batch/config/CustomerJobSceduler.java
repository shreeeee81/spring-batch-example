//package com.javatechie.spring.batch.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
//@Component
//@EnableScheduling
//public class CustomerJobSceduler {
//	@Autowired
//	private JobLauncher jobLauncher;
//	@Autowired
//	private Job job;
//	
//	// @Scheduled(cron = "*/5 * * * * *")
//    @Scheduled(fixedRate = 10000)
//    public void runJob1() {
//    	 JobParameters jobParameters = new JobParametersBuilder()
//    		        .addLong("startAt", System.currentTimeMillis()).toJobParameters();
//         try {
//             jobLauncher.run(job, jobParameters);
//         } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
//             e.printStackTrace();
//         }
//
//    }
//
//}
