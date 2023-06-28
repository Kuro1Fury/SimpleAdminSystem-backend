package com.example.SimpleManagementSystembackend.sys.service.impl;

import com.example.SimpleManagementSystembackend.sys.entity.User;
import com.example.SimpleManagementSystembackend.sys.mapper.UserMapper;
import com.example.SimpleManagementSystembackend.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
