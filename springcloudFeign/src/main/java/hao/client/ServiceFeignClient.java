package hao.client;

import common.entity.RestfulResult;
import hao.entity.ServiceInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Administrator on 2020/12/15.
 */
@FeignClient(value = "springbootService2",fallback = ServiceFallback.class) //这里的value对应调用服务的spring.applicatoin.name
public interface ServiceFeignClient {

    @PostMapping(value = "/service/hello",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RestfulResult hello(@RequestBody ServiceInfo serviceInfo);

}
