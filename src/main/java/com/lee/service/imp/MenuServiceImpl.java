package com.lee.service.imp;

import com.lee.entity.Menu;
import com.lee.mapper.MenuMapper;
import com.lee.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author ZiqiangLee
 * @since 2020-12-28
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
