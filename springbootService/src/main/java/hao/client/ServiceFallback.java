package hao.client;

import common.entity.RestfulResult;
import hao.service.ServiceInfo;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020/12/15.
 */
@Component
public class ServiceFallback implements ServiceFeignClient {
    @Override
    public RestfulResult hello(ServiceInfo serviceInfo) {
        RestfulResult result = new RestfulResult();
        result.setData("服务调用失败");
        return result;
    }

}
