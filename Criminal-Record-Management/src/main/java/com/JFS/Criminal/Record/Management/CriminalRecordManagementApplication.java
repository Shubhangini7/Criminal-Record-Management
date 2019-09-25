package com.JFS.Criminal.Record.Management;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync										//switches on Spring’s ability to run @Async methods in a background thread pool
public class CriminalRecordManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriminalRecordManagementApplication.class, args);
		
	}
	@Bean
    public Executor taskExecutor() {				// Executor helper class contains several methods for creation of pre-configured thread pool instances
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);				//defines minimum parallel threads can run at same time	
        executor.setMaxPoolSize(2);					//defines maximum parallel threads can run at same time
        executor.setQueueCapacity(500);				//Threads will be scalable to maximum pool size when queue is full
        //executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }


}
