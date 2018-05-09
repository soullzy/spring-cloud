package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li Zhengyue
 * @date 2018/4/8
 * @since JDK1.8
 */
@RestController
public class ClientController {
  private static int count = 0;
  @Autowired
  DiscoveryClient discoveryClient;

  @GetMapping("/dc")
  public String dc() throws InterruptedException {
    //设置超时时间，用于测试断路器
    if (count <= 10) {
      Thread.sleep(5000L);
      count++;
      System.out.println("current count="+count);
    }

    String services = "Services: " + discoveryClient.getServices();
    System.out.println("eureka client:" + services);
    return services;
  }
}
