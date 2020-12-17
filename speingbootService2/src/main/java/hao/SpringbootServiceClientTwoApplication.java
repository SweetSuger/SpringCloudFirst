package hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Created by yh on 2020/12/15.
 */
@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@RefreshScope
public class SpringbootServiceClientTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootServiceClientTwoApplication.class, args);
    }
}
