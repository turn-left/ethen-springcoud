package com.ethen.service.impl;

import com.ethen.entity.UserEntity;
import com.ethen.repository.UserRepository;
import com.ethen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public UserEntity findByFirstName(String firstName) {
        return null;
    }

    @Override
    public UserEntity findByFirstNameIs(String firstName) {
        return null;
    }

    @Override
    public UserEntity findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public UserEntity findByFirstNameOrLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<UserEntity> findByAgeBetween(int ageLower, int ageUpper) {
        return null;
    }

    @Override
    public List<UserEntity> findByAgeLessThan(int age) {
        return null;
    }

    @Override
    public List<UserEntity> findByAgeLessThanEqual(int age) {
        return null;
    }

    @Override
    public List<UserEntity> findByAgeGreaterThan(int age) {
        return null;
    }

    @Override
    public List<UserEntity> findByAgeGreaterThanEqual(int age) {
        return null;
    }

    @Override
    public List<UserEntity> findByAgeIsNull() {
        return null;
    }

    @Override
    public List<UserEntity> findByAgeNotNull() {
        return null;
    }

    @Override
    public List<UserEntity> findByFirstNameLike(String firstName) {
        return null;
    }
}
