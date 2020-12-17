package hao.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import hao.entity.RibbonServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yh on 2020/12/16.
 */
@RestController
public class RibbonController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    // 调用：localhost:6007/consumerServiceRibbon?token=1
    @RequestMapping("/consumerServiceRibbon")
    @HystrixCommand(fallbackMethod="consumerServiceRibbonFallback")
    public String consumerServiceRibbon(@RequestBody RibbonServiceInfo serviceInfo){
        try {
            String result = this.restTemplate.postForObject("http://springbootService/service/hello?token=1", serviceInfo, String.class);
            System.out.println(result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return "操作异常！";
        }
    }

    public String consumerServiceRibbonFallback(@RequestBody RibbonServiceInfo serviceInfo){
        return "consumerServiceRibbon异常，端口：" + port + "，Name=" + serviceInfo.getName();
    }

}
