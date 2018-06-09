package com.ITApp.SCN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StudentCampusNavigationAppApplication extends SpringBootServletInitializer{
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StudentCampusNavigationAppApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(StudentCampusNavigationAppApplication.class, args);
	}
}
