package com.lxt;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 打war包启动入口
 *
 * @author zer0
 * @version 1.0
 */
public class JeroServletInitializer extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JeroFileApplication.class);
    }
}
