package io.xstar.eurekaconsumerfeign.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Li Zhengyue
 * @date 2018/4/9
 * @since JDK1.8
 */
@FeignClient("eureka-client")
public interface Client {
  @GetMapping("/dc")
  String consumer();
}
