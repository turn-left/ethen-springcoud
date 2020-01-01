package com.ethen.app.mapper;

import com.ethen.app.dto.UserDto;

import java.util.List;

public interface UserMapper {

    List<UserDto> findByIdRange(int startIndex, int endIndex);
}
