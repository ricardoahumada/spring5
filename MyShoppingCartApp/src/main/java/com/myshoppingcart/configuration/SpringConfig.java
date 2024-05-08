package com.myshoppingcart.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ReposConfig.class})
public class SpringConfig {
}
