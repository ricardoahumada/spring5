package com.myshoppingcart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.myshoppingcart.persistence"})
@Import({RepoConfig.class, PropertyConfig.class, PropertyConfigDev.class})
public class SpringConfig {
}
