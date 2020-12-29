package com.lee.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.entity.User;
import com.lee.handler.BusinessException;
import com.lee.response.Result;
import com.lee.response.ResultCode;
import com.lee.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ZiqiangLee
 * @since 2020-12-28
 */
@RestController
@RequestMapping("/user")
@Api(value = "系统用户模块",tags = "系统用户接口")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "查询单个用户",notes = "查询特定id的用户信息")
    public Result getUserById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        if(user!=null){
            return Result.ok().data("user",user);
        }else {
            throw new BusinessException(ResultCode.USER_NOT_FOUND_EXCEPTION.getCode(),ResultCode.USER_NOT_FOUND_EXCEPTION.getMessage());
        }
    }

    @GetMapping("/findUserList")
    @ApiOperation(value = "分页查询",notes = "查询所有用户，分页进行显示")
    public Result findUserList(@RequestParam(required = true,defaultValue = "1") Integer current,
                               @RequestParam(required = true,defaultValue = "7")Integer size){
        Page<User> page = new Page<>(current, size);
        Page<User> userPage = userService.page(page);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        return Result.ok().data("total",total).data("records",records);

    }

}

