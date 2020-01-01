package com.ethen.app.service;

import com.ethen.app.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> listUserByIdRange(int startIndex, int endIndex);

    List<UserDto> listUserByIdRangeCachePut(int startIndex, int endIndex);
}
