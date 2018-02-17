package com.lxt.core.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = JeroProperties.PREFIX)
public class JeroProperties {

    public final static String PREFIX = "jero";

    private Boolean swaggerOpen = false;

    public Boolean getSwaggerOpen() {
        return swaggerOpen;
    }

    public void setSwaggerOpen(Boolean swaggerOpen) {
        this.swaggerOpen = swaggerOpen;
    }
}
