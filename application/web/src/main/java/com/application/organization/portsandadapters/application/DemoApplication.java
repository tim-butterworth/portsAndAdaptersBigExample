package com.application.organization.portsandadapters.application;

import com.application.organization.portsandadapters.shipments.ShipmentsSpringPointer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackageClasses = ShipmentsSpringPointer.class)
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
