package com.ethen.controller;

import com.ethen.common.ResponseVO;
import com.ethen.entity.UserEntity;
import com.ethen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j(topic = "hiyoyo")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object findUserById(@PathVariable Integer id) {
        log.info("");
        UserEntity userEntity = userService.findById(id);
        return ResponseVO.success(userEntity);
    }

}
