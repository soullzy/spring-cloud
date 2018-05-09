package io.xstar.configclientbus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@EnableEurekaClient
public class ConfigClientBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientBusApplication.class, args);
	}

  @Value("${test}")
  String test;

  @RequestMapping(value = "/hi")
  public String hi() {
    return "hello config bus " + test;
  }
}
