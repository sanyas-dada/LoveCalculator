package com.sanyasdada.ic.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sanyasdada.ic.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan({"com.sanyasdada.ic.controllers"})
public class LoveCalculatorAppConfig implements WebMvcConfigurer {

	// set up my view resolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());

		return localValidatorFactoryBean;
	}

	   
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setUsername("sanyasdada@gmail.com");
		javaMailSender.setPassword("sanyasdada123");
		javaMailSender.setPort(587);

		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		javaMailSender.setJavaMailProperties(mailProperties);
		return javaMailSender;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("inside addFormatter method()");

		registry.addFormatter(new PhoneNumberFormatter());
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

}
