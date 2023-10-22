package com.qingfeng.henthouse.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@ApiModel("用户注册")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {
    @ApiModelProperty(value = "用户名")
    @NotNull(message = "章节ID不能为null")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotNull(message = "章节ID不能为null")
    private String password;

    @ApiModelProperty(value = "重复密码")
    @NotNull(message = "章节ID不能为null")
    private String surePassword;

    @ApiModelProperty(value = "验证码")
    @NotNull(message = "章节ID不能为null")
    private String code;
}
