package io.xstar.eurekaconsumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。
 * 它是一个基于HTTP和TCP的客户端负载均衡器。
 * 它可以通过在客户端中配置ribbonServerList来设置服务端列表去轮询访问以达到均衡负载的作用
 *
 * @author Li Zhengyue
 * @date 2018/4/9
 * @since JDK1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerRibbonApplication {
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaConsumerRibbonApplication.class, args);
  }
}
