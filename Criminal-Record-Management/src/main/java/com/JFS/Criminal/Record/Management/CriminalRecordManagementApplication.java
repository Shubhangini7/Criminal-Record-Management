package com.JFS.Criminal.Record.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CriminalRecordManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriminalRecordManagementApplication.class, args);
		System.out.println("prints the connection has established successfully");
		
	}

}
