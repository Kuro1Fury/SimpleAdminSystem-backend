package com.example.SimpleManagementSystembackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.beans.BeanProperty;

@Configuration
public class MyCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Allow all domains to access
        configuration.addAllowedOrigin("http://localhost:8888");
        configuration.setAllowCredentials(true);
        configuration.addAllowedMethod("*");

        configuration.addAllowedHeader("*");

        // Allow all headers
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Apply the configuration to all paths
        source.registerCorsConfiguration("/**", configuration);

        return new CorsFilter(source);
    }
}
