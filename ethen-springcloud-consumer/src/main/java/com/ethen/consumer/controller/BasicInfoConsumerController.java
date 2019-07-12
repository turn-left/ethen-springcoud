package com.ethen.consumer.controller;


import com.ethen.consumer.service.BasicInfoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class BasicInfoConsumerController {


    @Autowired
    private BasicInfoFeignClient basicInfoFeignClient;

    @RequestMapping("/listProvinces")
    public Object listProvinces() {
        return basicInfoFeignClient.listProvinces();
    }
}
