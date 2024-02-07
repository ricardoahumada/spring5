package com.myshoppingcart.config;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@Profile("prod")
public class PropertyConfig {
}
