package com.ethen.consumer.service;

import com.ethen.common.domain.ProvinceVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 使用feign调用远程服务
 * todo 待启用ribbon hystrix等特性 fallback configuration
 */
@FeignClient(name = "ETHEN-SPRINGCLOUD-APP")
public interface BasicInfoFeignClient {

    @RequestMapping("/basic/listProvinces")
    List<ProvinceVO> listProvinces();
}
