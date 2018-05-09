package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li Zhengyue
 * @date 2018/4/8
 * @since JDK1.8
 */
@RestController
public class ClientController {
  @Autowired
  DiscoveryClient discoveryClient;

  //健康检查的实现REST部分
  @RequestMapping("/")
  public String home() { return "Hello world"; }

  @RequestMapping("/dc")
  public String dc() {
    String services = "Services: " + discoveryClient.getServices();
    System.out.println("consul client:"+services);
    return services;
  }
}
