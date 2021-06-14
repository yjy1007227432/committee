package com.committee.politics.committee_check;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.committee.politics.committee_check.dao")
public class CommitteeCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommitteeCheckApplication.class, args);
    }

}
