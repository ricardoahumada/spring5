package com.example.demo.config;

import com.example.demo.interceptors.ProductServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorsConfig implements WebMvcConfigurer {

    @Autowired
    ProductServiceInterceptor productServiceInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor).addPathPatterns("/productos/**");
    }
}
