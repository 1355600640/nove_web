package com.qingfeng.henthouse.common;

import org.springframework.security.core.AuthenticationException;

public class NotLoginExperience extends AuthenticationException {

    public NotLoginExperience(String msg) {
        super(msg);
    }
}
