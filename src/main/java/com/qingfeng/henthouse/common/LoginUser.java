package com.qingfeng.henthouse.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.qingfeng.henthouse.pojo.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {

    private UserInfo user;

    private List<String> authorys;

    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

    public LoginUser(UserInfo user) { this.user = user; }

    public LoginUser(UserInfo user,List<String> permissions){
        this.user = user;
        this.authorys = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(Objects.isNull(authorities)){
            authorities = authorys.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
