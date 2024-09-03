package com.banana.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.banana.persistence"})
public class RepoConfig {
}
