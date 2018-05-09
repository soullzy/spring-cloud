package io.xstar.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 属性必须配置在bootstrap.properties(yml)中，这样config-server中的配置信息才能被正确加载
 * 使用@RefreshScope注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
 *
 * @author Li Zhengyue
 * @date 2018/4/11
 * @since JDK1.8
 */
@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class ConfigClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
  }

  // git配置文件里的key
  @Value("${test}")
  String test;

  @RequestMapping(value = "/hi")
  public String hi() {
    return "hello " + test;
  }
}
