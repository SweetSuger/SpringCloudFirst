package hao.controller;

import common.entity.RestfulResult;
import common.utils.CommUtils;
import hao.service.ServiceInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "service")
public class ServiceController {

    @RequestMapping(value = "hello")
    public RestfulResult login(HttpServletRequest request, HttpServletResponse response, @RequestBody ServiceInfo serviceInfo) {
        RestfulResult restfulResult = new RestfulResult();
        try {
            restfulResult.setData("Service1:Welcome " + serviceInfo.getName() + "!");
        } catch (Exception e) {
            e.printStackTrace();
            restfulResult.setData("操作失败！");
        }
        //CommUtils.printDataJason(response, restfulResult);
        return restfulResult;
    }

    @RequestMapping(value = "rest")
    public String rest(@RequestBody ServiceInfo serviceInfo){
        return "Service1:Welcome " + serviceInfo.getName() + " !";
    }
}