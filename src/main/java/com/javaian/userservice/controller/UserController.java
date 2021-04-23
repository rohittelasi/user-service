package com.javaian.userservice.controller;

import com.javaian.userservice.entity.User;
import com.javaian.userservice.service.UserService;
import com.javaian.userservice.valueobject.ResponseTemplateValueObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public ResponseTemplateValueObject getUserDepartment(@PathVariable("id") Long userId) {
        logger.info("Retrieving user");
        return userService.getUserDepartment(userId);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        logger.info("Creating user");
        return userService.createUser(user);
    }
}
