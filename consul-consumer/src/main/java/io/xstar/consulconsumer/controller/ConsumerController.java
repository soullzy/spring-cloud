package io.xstar.consulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li Zhengyue
 * @date 2018/4/9
 * @since JDK1.8
 */
@RestController
public class ConsumerController {
  @Autowired
  LoadBalancerClient loadBalancerClient;
  @Autowired
  RestTemplate restTemplate;

  @RequestMapping("/check")
  public String check() {
    //健康检查不能配置成health
    return "hello world consul consumer";
  }

  @GetMapping("/consumer")
  public String dc() {
    ServiceInstance serviceInstance = loadBalancerClient.choose("consul-client");
    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
    System.out.println(url);
    return restTemplate.getForObject(url, String.class);
  }
}
