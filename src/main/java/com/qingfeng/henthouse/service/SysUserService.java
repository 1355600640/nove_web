package com.qingfeng.henthouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingfeng.henthouse.Dto.UserRegisterDto;
import com.qingfeng.henthouse.pojo.SysUser;
import com.qingfeng.henthouse.pojo.UserInfo;

public interface SysUserService extends IService<UserInfo> {
    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    public String userLogin(SysUser sysUser);

    /**
     * 用户注册
     * @param user 用户信息
     * @param ip IP地址
     * @return
     */
    public Boolean userRegister(UserRegisterDto user,String ip);
}
