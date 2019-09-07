package com.zhangcw.driving_schooling_manage_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DrivingSchoolingManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrivingSchoolingManageSystemApplication.class, args);
    }
}
