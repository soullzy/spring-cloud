package io.xstar.eurekaconsumerribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  RestTemplate restTemplate;

  @GetMapping("/consumer")
  public String dc() {
    System.out.println("eureka consumer ribbon");
    return restTemplate.getForObject("http://eureka-client/dc", String.class);
  }
}
