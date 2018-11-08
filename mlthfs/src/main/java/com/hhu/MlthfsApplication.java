package com.hhu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = "com.hhu.mlthfs.*")
public class MlthfsApplication  {

    public static final Logger log = LoggerFactory.getLogger(MlthfsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MlthfsApplication.class, args);

        log.info("===========spring boot==项目启动成功======");
    }


//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(MlthfsApplication.class);
//    }
}
