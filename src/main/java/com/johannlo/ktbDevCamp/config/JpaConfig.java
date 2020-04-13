package com.johannlo.ktbDevCamp.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.johannlo.ktbDevCamp.repository")
public class JpaConfig {

}