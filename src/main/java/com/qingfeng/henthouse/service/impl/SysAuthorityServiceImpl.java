package com.qingfeng.henthouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.henthouse.mapper.SysAuthorityMapper;
import com.qingfeng.henthouse.mapper.SysUserAuthorityMapper;
import com.qingfeng.henthouse.pojo.SysAuthority;
import com.qingfeng.henthouse.pojo.SysUserAuthority;
import com.qingfeng.henthouse.service.SysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SysAuthorityServiceImpl extends ServiceImpl<SysAuthorityMapper, SysAuthority> implements SysAuthorityService {

    @Autowired
    private SysUserAuthorityMapper mapper;


    @Override
    public List<SysAuthority> SelectAuthorityById(String id) {
        LambdaQueryWrapper<SysUserAuthority> wrapper = new LambdaQueryWrapper<SysUserAuthority>();
        LambdaQueryWrapper<SysAuthority> authorityLambdaQueryWrapper = new LambdaQueryWrapper<SysAuthority>();
        wrapper.eq(SysUserAuthority::getUserId,id);
        List<SysUserAuthority> sysUserAuthorities = mapper.selectList(wrapper);
        if(sysUserAuthorities.size()==0) return new ArrayList<>();
        List<Integer> collect = sysUserAuthorities.stream().map(SysUserAuthority::getUserId).collect(Collectors.toList());
        List<SysAuthority> sysAuthorities = this.listByIds(collect);
        return sysAuthorities;
    }
}
