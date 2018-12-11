package com.javazhilu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableDiscoveryClient //作用是 如果服务使用connsul 或者zookeeper  使用这个注解 像注册中心注册服务
public class ZkOrderController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/orderToMember")
    public String orderToMember() {
        String memberUrl = "http://zk-member/getMember";

        return restTemplate.getForObject(memberUrl, String.class);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZkOrderController.class, args);
    }
}
