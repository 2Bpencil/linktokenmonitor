package com.tyf.linktokenmonitor.code.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: tyf
 * @Date: 2019/7/6 19:05
 * @Description:
 */
@Component
@PropertySource(value = { "classpath:config.properties" },ignoreResourceNotFound = true)
public class DataConfig {

    @Value("${linktokens}")
    private String linktokens;

    public String getLinktokens() {
        return linktokens;
    }

    public void setLinktokens(String linktokens) {
        this.linktokens = linktokens;
    }
}
