package com.qingfeng.henthouse.enmus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CodeSource {

    UserCode("user_code");
    private String msg;
}
