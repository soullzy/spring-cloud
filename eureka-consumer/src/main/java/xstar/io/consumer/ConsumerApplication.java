package xstar.io.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient注解用来将当前应用加入到服务治理体系中。
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
  //初始化RestTemplate，用来真正发起REST请求
  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

	public static void main(String[] args) {
	  SpringApplication.run(ConsumerApplication.class, args);
	}
}
