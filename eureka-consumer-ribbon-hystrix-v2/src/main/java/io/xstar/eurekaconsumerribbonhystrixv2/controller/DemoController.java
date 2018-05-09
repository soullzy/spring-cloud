package io.xstar.eurekaconsumerribbonhystrixv2.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li Zhengyue
 * @date 2018/4/10
 * @since JDK1.8
 */
@RestController
public class DemoController {
  @Autowired
  ConsumerService consumerService;

  @GetMapping("/consumer")
  public String dc() {
    System.out.println("consumer ribbon hystrix version2 start");
    return consumerService.consumer();
  }

  @Service
  class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
      return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String fallback() {
      return "fallbck";
    }
  }
}
