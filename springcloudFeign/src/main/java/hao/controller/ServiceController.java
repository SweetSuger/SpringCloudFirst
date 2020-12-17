package hao.controller;

import common.entity.RestfulResult;
import common.utils.CommUtils;
import hao.client.ServiceFeignClient;
import hao.entity.ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2020/12/15.
 */
@RestController
public class ServiceController {

    @Autowired
    ServiceFeignClient serviceFeignClient;

    // 调用：localhost:6004/consumerService?token=1
    @RequestMapping("/consumerService")
    public void consumerService(HttpServletRequest request, HttpServletResponse response,
                                @RequestBody ServiceInfo info){
        RestfulResult restfulResult =  serviceFeignClient.hello(info);
        CommUtils.printDataJason(response, restfulResult);
    }
}
