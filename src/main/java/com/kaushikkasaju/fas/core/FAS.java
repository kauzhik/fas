package com.kaushikkasaju.fas.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.kaushikkasaju.fas")
public class FAS {
    public static void main(String[] args){
        new SpringApplicationBuilder(FAS.class)
                .initializers(new FASInitializer())
                .run(args);
    }
}