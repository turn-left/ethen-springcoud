package com.ethen.app.controller;

import com.ethen.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主要用来测试spring声明式缓存(注解缓存)
 * <p>
 * fixme了解缓存注解的原理
 *
 * @see {https://blog.csdn.net/f641385712/article/details/94570960}
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list/{startIndex}/{endIndex}")
    public Object listByRange(@PathVariable int startIndex, @PathVariable int endIndex) {
        return userService.listUserByIdRange(startIndex, endIndex);
    }

    @GetMapping("/list/refresh/{startIndex}/{endIndex}")
    public Object listByRangeCachePut(@PathVariable int startIndex, @PathVariable int endIndex) {
        userService.listUserByIdRangeCachePut(startIndex, endIndex);
        return "OK";
    }
}
