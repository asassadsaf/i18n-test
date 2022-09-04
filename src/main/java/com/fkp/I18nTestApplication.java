package com.fkp;

import com.fkp.util.I18nUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class I18nTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(I18nTestApplication.class, args);
//        I18nUtils.getMessage("000000");
    }

}
