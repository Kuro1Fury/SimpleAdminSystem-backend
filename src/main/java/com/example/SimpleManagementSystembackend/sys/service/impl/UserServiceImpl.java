package com.example.SimpleManagementSystembackend.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.SimpleManagementSystembackend.sys.entity.User;
import com.example.SimpleManagementSystembackend.sys.mapper.UserMapper;
import com.example.SimpleManagementSystembackend.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kuro
 * @since 2023-06-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(User user) {
        // Select based on username and password
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);

        // If the user exists, create a token and store the user information into Redis
        if (loginUser != null) {
            // Create a token
            // Current: UUID, Ultimate: jwt
            String key = "user: " + UUID.randomUUID();

            // Store the user information into Redis
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key, loginUser, 30, TimeUnit.MINUTES);

            // return the token
            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }

        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        // Get the user information by token from Redis
        Object obj = redisTemplate.opsForValue().get(token);
        // Deserialize the user information
        if (obj != null) {
            User loginUser = JSON.parseObject(JSON.toJSONString(obj), User.class);
            Map<String, Object> data = new HashMap<>();
            data.put("name", loginUser.getUsername());
            data.put("avatar", loginUser.getAvatar());

            List<String> roleList = this.baseMapper.getRoleNameByUserId(loginUser.getId());
            data.put("roles", roleList);
            return data;
        }

        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}
