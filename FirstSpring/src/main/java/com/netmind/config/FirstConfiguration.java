package com.netmind.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MessageConfig.class, UsuarioConfig.class})
public class FirstConfiguration {

}
