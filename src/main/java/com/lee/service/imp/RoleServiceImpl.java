package com.lee.service.imp;

import com.lee.entity.Role;
import com.lee.mapper.RoleMapper;
import com.lee.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ZiqiangLee
 * @since 2020-12-28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
