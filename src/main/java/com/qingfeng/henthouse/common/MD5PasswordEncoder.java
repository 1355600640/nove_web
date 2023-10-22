package com.qingfeng.henthouse.common;

import com.qingfeng.henthouse.utils.MD5UtilBetter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MD5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5UtilBetter.encode((String)rawPassword);
    }


    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encode = MD5UtilBetter.encode((String) rawPassword);
        return  encodedPassword.equals(MD5UtilBetter.encode((String)rawPassword));
    }
}
