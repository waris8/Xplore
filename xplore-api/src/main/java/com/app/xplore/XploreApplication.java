package com.app.xplore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.app.xplore",
    "com.app.xplore.user",
    "com.app.xplore.room",
    "com.app.xplore.feed",
    "com.app.xplore.notification"
})
@EntityScan({
    "com.app.xplore.model",
    "com.app.xplore.user.model",
    "com.app.xplore.room.model",
    "com.app.xplore.feed.model"
})
@EnableJpaRepositories({
    "com.app.xplore.repository",
    "com.app.xplore.user.repository",
    "com.app.xplore.room.repository",
    "com.app.xplore.feed.repository"
})
public class XploreApplication {
    public static void main(String[] args) {
        SpringApplication.run(XploreApplication.class, args);
    }
}
