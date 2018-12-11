package com.javazhilu.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient //作用是 如果服务使用connsul 或者zookeeper  使用这个注解 像注册中心注册服务
public class ZkMemberController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getMember")
    public String getMember() {
        return "会员服务接口，端口号为：" + serverPort;
    }

    public static void main(String[] args) {
        SpringApplication.run(ZkMemberController.class, args);
    }
}
