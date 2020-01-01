package com.ethen.app.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private int age;
}