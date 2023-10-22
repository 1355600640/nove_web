package com.qingfeng.henthouse.filter;

import com.qingfeng.henthouse.common.LoginUser;
import com.qingfeng.henthouse.common.NotLoginExperience;
import com.qingfeng.henthouse.handle.AuthenticationEntryPointImpl;
import com.qingfeng.henthouse.utils.JwtUtil;
import com.qingfeng.henthouse.utils.RedisCache;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    RedisCache redisCache;

    @Autowired
    AuthenticationEntryPointImpl authenticationEntryPointProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        String id,ip;
        id = ip = "";
        if (token!= null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }else {
            filterChain.doFilter(request, response);
            return;
        }
        try{
            Claims claims = JwtUtil.parseJWT(token);
            id = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            authenticationEntryPointProvider.commence(request,response,new NotLoginExperience("Token非法"));
            return;
        }
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = request.getHeader("x-forwarded-for");
        }
        log.info("ip地址:"+ip+"\t访问了主机");
        LoginUser loginUser = redisCache.getCacheObject("User-novel:" + id);
        if (loginUser == null) {
            authenticationEntryPointProvider.commence(request,response,new NotLoginExperience("用户未登录"));
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }

}
