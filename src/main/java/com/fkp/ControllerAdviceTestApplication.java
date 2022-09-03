package com.fkp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ControllerAdviceTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ControllerAdviceTestApplication.class, args);
        Object i18nUtils = run.getBean("i18nUtils");
        System.out.println(i18nUtils);
    }

}
