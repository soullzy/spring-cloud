package io.xstar.eurekaconsumerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * hystrix的断路器实现了对依赖资源故障的端口、对降级策略的自动切换以及对主逻辑的自动恢复机制
 * 这使得我们的微服务在依赖外部服务或资源的时候得到了非常好的保护，
 * 同时对于一些具备降级逻辑的业务需求可以实现自动化的切换与恢复，
 * 相比于设置开关由监控和运维来进行切换的传统实现方式显得更为智能和高效。
 *
 * @author Li Zhengyue
 * @date 2018/4/10
 * @since JDK1.8
 */
@SpringCloudApplication
public class EurekaConsumerRibbonHystrixApplication {
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaConsumerRibbonHystrixApplication.class, args);
  }
}
