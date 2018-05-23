package com.boraji.tutorial.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class MainApp {

	private static Logger logger = LogManager.getLogger(MainApp.class);

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	/*public static void main(String[] args) {
		logger.info("Starting Spring Boot application..");
		SpringApplication app = new SpringApplication(MainApp.class);
		app.run(args);
		try {
			// Generating Sample Exception
			throw new Exception("Generating Exception To Test Log4j Mail Notification...");
		} catch (Exception exObj) {
			logger.error("Sample Result?= " + exObj);
		}
	}*/
}
