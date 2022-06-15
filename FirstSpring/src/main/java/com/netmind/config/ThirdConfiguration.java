package com.netmind.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.netmind.modelos")
@Import({MessageConfig.class})
public class ThirdConfiguration {
}
