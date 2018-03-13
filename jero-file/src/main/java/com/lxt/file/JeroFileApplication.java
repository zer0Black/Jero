package com.lxt.file;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("com.lxt")
@MapperScan(basePackages = "com.lxt.file.mapper")
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class JeroFileApplication {

    private static final Logger logger = LoggerFactory.getLogger(JeroFileApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JeroFileApplication.class, args);
        logger.info("JeroFileApplication started successfully!");
    }

}
