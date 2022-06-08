package com.ricardo.config;

import com.ricardo.persistence.StudentsRepository;
import com.ricardo.services.StudentsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

@Configuration
@ComponentScan({"com.ricardo.persistence","com.ricardo.services"})
@Import({SchoolConfig.class})
public class SpringConfig {
}
