package com.kaushikkasaju.fas.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.kaushikkasaju.fas.repository")
@EntityScan(basePackages = "com.kaushikkasaju.fas.model")
@EnableTransactionManagement
public class RepositoryConfig {

}
