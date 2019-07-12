package com.ethen.app.controller;

import com.ethen.app.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicInfoController {

    @Autowired
    private BasicInfoService basicInfoService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/listProvinces")
    public Object listProvinces() {
        return basicInfoService.listProvinces();
    }


    @RequestMapping(value = "/testLoadBalance", method = RequestMethod.GET)
    public Object testLoadBalance() {
        return "SERVER-PORT:" + port;
    }

}
