package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulClientApplication {

	public static void main(String[] args) {
	  //consul download url=https://blog.csdn.net/forezp/article/details/70245644
		SpringApplication.run(ConsulClientApplication.class, args);
	}
}
