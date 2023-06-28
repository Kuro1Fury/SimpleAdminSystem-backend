package com.example.SimpleManagementSystembackend.sys.mapper;

import com.example.SimpleManagementSystembackend.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kuro
 * @since 2023-06-28
 */
public interface UserMapper extends BaseMapper<User> {
//    @Select(...)
    public List<String> getRoleNameByUserId(Integer id);

}
