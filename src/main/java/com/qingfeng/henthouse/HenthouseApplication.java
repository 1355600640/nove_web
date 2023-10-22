package com.qingfeng.henthouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class HenthouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HenthouseApplication.class, args);
    }

}
