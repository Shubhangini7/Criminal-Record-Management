package com.JFS.Criminal.Record.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //connection establish by auto configuration
public class CriminalRecordManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriminalRecordManagementApplication.class, args);
		System.out.println("connection has established successfully");
		
	}

}
