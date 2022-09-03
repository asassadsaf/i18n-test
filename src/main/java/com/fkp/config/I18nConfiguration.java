package com.fkp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class I18nConfiguration {

    @Bean
    public LocaleResolver localeResolver(){
        return new I18nLocaleResolver();
    }

    static class I18nLocaleResolver implements LocaleResolver{

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String lang = request.getHeader("lang");
            Locale locale = Locale.getDefault();
            if("zh_CN".equals(lang)){
                locale = Locale.SIMPLIFIED_CHINESE;
            }else if("en_US".equals(lang)){
                locale = Locale.US;
            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

        }
    }
}
