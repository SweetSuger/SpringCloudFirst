package hao.controller;

import common.entity.RestfulResult;
import common.utils.CommUtils;
import hao.service.ServiceInfo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "service")
public class ServiceController {

    @PostMapping(value = "hello")
    public void login(HttpServletRequest request, HttpServletResponse response,
                      @RequestBody ServiceInfo serviceInfo) {

        RestfulResult restfulResult = new RestfulResult();
        try {
            restfulResult.setData("Service2:Welcome " + serviceInfo.getName() + "!");
//            Thread.sleep(5000);
        } catch (Exception e) {

            e.printStackTrace();
        }
        CommUtils.printDataJason(response, restfulResult);
    }

    @RequestMapping(value = "rest")
    public String rest(@RequestBody ServiceInfo serviceInfo){
        return "Service2:Welcome " + serviceInfo.getName() + " !";
    }

}