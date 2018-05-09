package io.xstar.eurekaconsumerribbonhystrixv2;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Li Zhengyue
 * @date 2018/4/10
 * @since JDK1.8
 */
@SpringCloudApplication
public class EurekaConsumerRibbonHystrixV2Application {
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaConsumerRibbonHystrixV2Application.class, args);
  }
}
