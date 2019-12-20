package com.ethen.service.impl;

import com.ethen.entity.UserEntity;
import com.ethen.repository.UserRepository;
import com.ethen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * JPA基础用法示例与探索
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findById(Integer id) {
        return userRepository.findById(id).get();
    }
}
