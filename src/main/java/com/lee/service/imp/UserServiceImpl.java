package com.lee.service.imp;

import com.lee.entity.User;
import com.lee.mapper.UserMapper;
import com.lee.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ZiqiangLee
 * @since 2020-12-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
