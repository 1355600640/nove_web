package com.qingfeng.henthouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qingfeng.henthouse.pojo.SysAuthority;

import java.util.List;


public interface SysAuthorityService extends IService<SysAuthority> {

    /**
     * 根据用户id差选权限
     * @param id
     * @return 权限组
     */
    public List<SysAuthority> SelectAuthorityById(String id);
}
