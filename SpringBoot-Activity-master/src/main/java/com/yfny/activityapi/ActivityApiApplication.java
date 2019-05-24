package com.yfny.activityapi;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 */
//这里要屏蔽SecurityAutoConfiguration.class,不然登陆Activity-Modeler的时候要输入账号密码
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableTransactionManagement//起用事务
public class ActivityApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApiApplication.class, args);
    }

}
