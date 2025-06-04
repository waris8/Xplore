package com.app.xplore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableJpaRepositories(basePackages = "com.app.xplore.repository")
@EntityScan(basePackages = "com.app.xplore.models")
@ComponentScan(basePackages = "com.app.xplore")
@PropertySource({
    "classpath:application.yml",
    "file:/opt/xplore/prop/application.properties"
})
public class XploreApplication {

    public static void main(String[] args) {
        SpringApplication.run(XploreApplication.class, args);
    }
}
