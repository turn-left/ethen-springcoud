package com.ethen.app.service.impl;

import com.ethen.app.mapper.BasicInfoMapper;
import com.ethen.app.service.BasicInfoService;
import com.ethen.common.domain.ProvinceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInfoImpl implements BasicInfoService {

    @Autowired
    BasicInfoMapper mapper;

    @Override
    public List<ProvinceVO> listProvinces() {
        return mapper.listProvinces();
    }
}
