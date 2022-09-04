package com.fkp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class I18nConfiguration {

    @Bean
    public LocaleResolver localeResolver(){
        return new I18nLocaleResolver();
    }

    static class I18nLocaleResolver implements LocaleResolver{

        private static final List<String> languageTagList;

        static {
            //初始化可使用的国家和地区的语言表示，格式为： 国家_语言
            languageTagList = Stream.of(Locale.getAvailableLocales()).map(value -> value.toLanguageTag().replaceFirst("-", "_")).filter(value -> value.contains("_")).collect(Collectors.toList());
        }

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String lang = request.getHeader("lang");
            Locale locale = Locale.getDefault();
            //通用写法
            if (languageTagList.contains(lang)) {
                locale = Locale.forLanguageTag(lang.replaceFirst("_", "-"));
            }
            //若仅为中文和英文或少数语言进行国际化可以照此写法
//            if("zh_CN".equals(lang)){
//                locale = Locale.SIMPLIFIED_CHINESE;
//            }else if("en_US".equals(lang)){
//                locale = Locale.US;
//            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

        }
    }
}
