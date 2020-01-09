package com.ethen.app.service.impl;

import com.ethen.app.dto.UserDto;
import com.ethen.app.mapper.UserMapper;
import com.ethen.app.service.UserService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * user业务类
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "user_list", unless = "#startIndex <= 100")
    public List<UserDto> listUserByIdRange(int startIndex, int endIndex) {
        return userMapper.findByIdRange(startIndex, endIndex);
    }

    @Override
    @CachePut(value = "user_list", key = "'from-' + #result.get(0).id +'-to-' + #result.get(#result.size()-1).id", condition = "#result.size() > 0")
    public List<UserDto> listUserByIdRangeCachePut(int startIndex, int endIndex) {
        return userMapper.findByIdRange(startIndex, endIndex);
    }
}
