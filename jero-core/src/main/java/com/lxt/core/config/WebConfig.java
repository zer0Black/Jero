package com.lxt.core.config;

import com.lxt.core.filter.CorsFilter;
import com.lxt.core.filter.DecodeUrlFilter;
import com.lxt.core.filter.RequestInfoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Web配置，用于注入过滤器，拦截器等
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(10);
        return registration;
    }

    @Bean
    public FilterRegistrationBean decodeFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DecodeUrlFilter());
        registration.addUrlPatterns("/*");
        registration.setName("decodeFilter");
        registration.setOrder(11);
        return registration;
    }

    @Bean
    public FilterRegistrationBean requestFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestInfoFilter());
        registration.addUrlPatterns("/*");
        registration.setName("requestFilter");
        registration.setOrder(12);
        return registration;
    }

}
