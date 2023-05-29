package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/avatar/**").addResourceLocations("file:E:/WorkingSpace/2022/基于Java的WEB开发/Project/Final/img/avatar/");
        registry.addResourceHandler("/img/intro/**").addResourceLocations("file:E:/WorkingSpace/2022/基于Java的WEB开发/Project/Final/img/intro/");
    }
}
