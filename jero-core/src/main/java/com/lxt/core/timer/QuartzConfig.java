package com.lxt.core.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz配置
 * @Configuration注解相当于 <beans></beans> 配置
 * spring boot 框架会自动扫描注入成bean
 *
 * @author lixuetao
 * @version 1.0
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private AutowiredJobFactory autowiredJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(autowiredJobFactory);
        return schedulerFactoryBean;
    }

}
