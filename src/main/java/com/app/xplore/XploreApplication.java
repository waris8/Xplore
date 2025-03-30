package com.app.xplore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:/opt/xplore/prop/application.properties")
public class XploreApplication {

	public static void main(String[] args) {
		SpringApplication.run(XploreApplication.class, args);
	}

}
