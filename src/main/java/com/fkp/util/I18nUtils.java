package com.fkp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class I18nUtils {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key){
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

}
