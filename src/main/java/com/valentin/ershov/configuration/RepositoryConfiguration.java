package com.valentin.ershov.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.valentin.ershov.domain"})
@EnableJpaRepositories(basePackages = {"com.valentin.ershov.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
