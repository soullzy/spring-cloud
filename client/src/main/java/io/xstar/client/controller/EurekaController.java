package io.xstar.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li Zhengyue
 * @date 2018/3/8
 * @since JDK1.8
 */
@RestController
public class EurekaController {
  @Value("${server.port}")
  String port;

  @RequestMapping("/hi")
  public String index(@RequestParam String name) {
    return "hi " + name + ",i am from port:" + port;
  }
}
