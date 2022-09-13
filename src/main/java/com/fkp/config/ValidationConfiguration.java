package com.fkp.config;

import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * 配置校验实现国际化
 */
@Configuration
public class ValidationConfiguration {

    @Resource
    ApplicationContext applicationContext;

    @Bean
    public Validator validator(MessageSource messageSource){
        LocalValidatorFactoryBean validator = ValidationAutoConfiguration.defaultValidator(applicationContext);
        validator.setValidationMessageSource(messageSource);
        return validator;
    }
}
