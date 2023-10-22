package com.qingfeng.henthouse.enmus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum ControlStatus {

    SUSSES(200,"成功"),
//    authentication failure
    AUTHORIZATION_FAILURE(401,"授权失败"),
    AUTHENTICATION_FAILURE(405,"认证失败"),
    ERROR_PAGE_FOUND(404,"路径未找到"),
    ERROR_DATA_EMPEY(403,"参数错误"),
    ERROR_PARAM(402,"无数据"),
    FAIL(400,"失败");

    private Integer errorCode;
    private String errorMsg;
}
