package com.stocks.dev.stocks.util;

import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class PublishableTokenUtil {
    public String getPublichableTokenByUrl(String stringUrl) {
        String query = null;
        try {
            query = new URL(stringUrl).getQuery();
            return query.substring(query.indexOf('=') + 1);
        } catch (MalformedURLException e) {
            e.getMessage();
        }
        return query;
    }
}
