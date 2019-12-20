package com.ethen.service;

import com.ethen.entity.UserEntity;

import java.util.List;

/**
 * JPA基础用法示例与探索
 */
public interface UserService {

    UserEntity findById(Integer id);

    UserEntity findByFirstName(String firstName);

    UserEntity findByFirstNameIs(String firstName);

    UserEntity findByFirstNameAndLastName(String firstName, String lastName);

    UserEntity findByFirstNameOrLastName(String firstName, String lastName);

    List<UserEntity> findByAgeBetween(int ageLower, int ageUpper);

    List<UserEntity> findByAgeLessThan(int age);

    List<UserEntity> findByAgeLessThanEqual(int age);

    List<UserEntity> findByAgeGreaterThan(int age);

    List<UserEntity> findByAgeGreaterThanEqual(int age);

    List<UserEntity> findByAgeIsNull();

    List<UserEntity> findByAgeNotNull();

    List<UserEntity> findByFirstNameLike(String firstName);


}
