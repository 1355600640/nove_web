package com.qingfeng.henthouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qingfeng.henthouse.Dto.UserRegisterDto;
import com.qingfeng.henthouse.common.LoginUser;
import com.qingfeng.henthouse.common.MD5PasswordEncoder;
import com.qingfeng.henthouse.common.MethodsErrorException;
import com.qingfeng.henthouse.enmus.CodeSource;
import com.qingfeng.henthouse.mapper.UserInfoMapper;
import com.qingfeng.henthouse.pojo.SysUser;
import com.qingfeng.henthouse.pojo.UserInfo;
import com.qingfeng.henthouse.service.SysUserService;
import com.qingfeng.henthouse.utils.JwtUtil;
import com.qingfeng.henthouse.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Objects;

@Service
public class SysUserServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements SysUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    MD5PasswordEncoder encoder;


    @Override
    public String userLogin(SysUser user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
             throw new MethodsErrorException("账号或密码错误");
        }
        LoginUser loginUser =  (LoginUser) authenticate.getPrincipal();
        Long id = loginUser.getUser().getId();
        // 根据id生成Token，并存入redis
        String jwt = JwtUtil.createJWT(id.toString());
        redisCache.setCacheObject("User-novel:"+id,loginUser);
        return jwt;
    }

    @Override
    public Boolean userRegister(UserRegisterDto user , String ip) {
        Map<String,Object> cacheMap =null;
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUsername,user.getUsername());
        if(!Objects.isNull(this.getOne(wrapper))){
            throw new MethodsErrorException("用户名已存在");
        }
        if(!user.getPassword().equals(user.getSurePassword())) throw new RuntimeException("两次密码不一致");
        try{
            cacheMap = redisCache.getCacheObject(CodeSource.UserCode.getMsg()+":" + ip);
        }catch (Exception e){
            throw new MethodsErrorException("请获取验证码");
        }
        if(cacheMap==null)  throw new MethodsErrorException("请获取验证码");
        String code =  (String) cacheMap.get("code");
        long lastTime =  LocalDateTime.parse((String)cacheMap.get("time")).toEpochSecond(ZoneOffset.ofHours(8));
        long epochSecond = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8));
        if((epochSecond-lastTime)/60>=5){
            throw new MethodsErrorException("验证码过期，请重试");
        }
        if(!code.equals(user.getCode()))throw new MethodsErrorException("验证码错误");
        UserInfo userInfo = UserInfo.builder()
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .nickName(user.getUsername())
                .salt("0").build();
        return this.save(userInfo);
    }
}
