package com.qingfeng.henthouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qingfeng.henthouse.common.LoginUser;
import com.qingfeng.henthouse.mapper.UserInfoMapper;
import com.qingfeng.henthouse.pojo.SysAuthority;
import com.qingfeng.henthouse.pojo.UserInfo;
import com.qingfeng.henthouse.service.SysAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoMapper userMapper;

    @Autowired
    private SysAuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUsername,username);
        UserInfo userInfo = userMapper.selectOne(wrapper);
        if(Objects.isNull(userInfo)){
            throw new RuntimeException("用户不存在");
        }
        List<SysAuthority> sysAuthorities = authorityService.SelectAuthorityById(userInfo.getId().toString());
        List<String> collect = new ArrayList<>();
        if(sysAuthorities.size()>0)
            collect = sysAuthorities.stream().map(SysAuthority::getAuthority).collect(Collectors.toList());
        LoginUser loginUser = new LoginUser(userInfo,collect);
        return loginUser;
    }
}
