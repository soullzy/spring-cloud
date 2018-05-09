package io.xstar.eurekaconsumerfeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li Zhengyue
 * @date 2018/4/9
 * @since JDK1.8
 */
@RestController
public class ConsumerController {
  @Autowired
  Client client;

  @GetMapping("/consumer")
  public String dc() {
    return client.consumer();
  }
}
