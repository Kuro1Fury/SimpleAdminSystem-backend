package com.example.SimpleManagementSystembackend.sys.service.impl;

import com.example.SimpleManagementSystembackend.sys.entity.Menu;
import com.example.SimpleManagementSystembackend.sys.mapper.MenuMapper;
import com.example.SimpleManagementSystembackend.sys.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
