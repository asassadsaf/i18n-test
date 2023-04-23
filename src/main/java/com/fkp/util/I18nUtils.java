package com.fkp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class I18nUtils {

    private static MessageSource messageSource;

    @Autowired
    private void setMessageSource(MessageSource messageSource){
        I18nUtils.messageSource = messageSource;
    }

    public static String getMessage(String key){
        String langMessage = key;
        try {
         langMessage = messageSource.getMessage(key, new Object[]{}, LocaleContextHolder.getLocale());
        }catch (NoSuchMessageException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            langMessage = "i18n inner error!";
        }
        return langMessage;
    }

    public static String getMessageWithArgs(String key, String[] args){
        List<String> argMessageList = new ArrayList<>();
        for (String arg : args) {
            String argMessage = messageSource.getMessage(arg, null, "", LocaleContextHolder.getLocale());
            argMessageList.add(argMessage);
        }
        return messageSource.getMessage(key, argMessageList.toArray(), "unknow error", LocaleContextHolder.getLocale());
    }

}
