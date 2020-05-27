package com.stocks.dev.stocks.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:data.properties")
public class DataProperties {
}
