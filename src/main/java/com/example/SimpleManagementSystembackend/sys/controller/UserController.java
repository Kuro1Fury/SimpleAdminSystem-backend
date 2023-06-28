package com.example.SimpleManagementSystembackend.sys.controller;

import com.example.SimpleManagementSystembackend.sys.entity.User;
import com.example.SimpleManagementSystembackend.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kuro
 * @since 2023-06-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public List<User> getAllUser() {
        List<User> list = userService.list();
        return list;
    }

}
