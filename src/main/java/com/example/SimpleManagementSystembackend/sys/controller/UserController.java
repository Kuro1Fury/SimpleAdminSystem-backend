package com.example.SimpleManagementSystembackend.sys.controller;

import com.example.SimpleManagementSystembackend.common.vo.Result;
import com.example.SimpleManagementSystembackend.sys.entity.User;
import com.example.SimpleManagementSystembackend.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public Result<List<User>> getAllUser() {
        List<User> list = userService.list();
        return Result.success(list, "Select success!");
    }

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> data =  userService.login(user);

        if (data != null) {
            return Result.success(data);
        }

        return Result.fail(20002, "Username or Password failed!");
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token) {
        // Get the user information by token from Redis
        Map<String, Object> data = userService.getUserInfo(token);

        if (data != null) {
            return Result.success(data);
        }
        return Result.fail(20003, "login expired, please login again!");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token) {
        userService.logout(token);
        return Result.success("Logout success!");
    }

}
