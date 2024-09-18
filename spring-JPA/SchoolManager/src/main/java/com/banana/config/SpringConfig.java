package com.banana.config;

import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan({"com.banana.persistence"})
//@PropertySource("classpath:application.properties")
@Import({RepoConfig.class, ServicesConfig.class, PropertiesConfig.class, PropertiesConfigDev.class})
public class SpringConfig {



}
