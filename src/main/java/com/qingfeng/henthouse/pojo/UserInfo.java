package com.qingfeng.henthouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 */
@ApiModel(description = "用户信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "user_info")
public class UserInfo implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 登录名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "登录名")
    @Size(max = 50, message = "登录名最大长度要小于 50")
    @NotBlank(message = "登录名不能为空")
    private String username;

    /**
     * 登录密码-加密
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value = "登录密码-加密")
    @Size(max = 100, message = "登录密码-加密最大长度要小于 100")
    @NotBlank(message = "登录密码-加密不能为空")
    private String password;

    /**
     * 加密盐值
     */
    @TableField(value = "salt")
    @ApiModelProperty(value = "加密盐值")
    @Size(max = 8, message = "加密盐值最大长度要小于 8")
    @NotBlank(message = "加密盐值不能为空")
    private String salt;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    @ApiModelProperty(value = "昵称")
    @Size(max = 50, message = "昵称最大长度要小于 50")
    private String nickName;

    /**
     * 用户头像
     */
    @TableField(value = "user_photo")
    @ApiModelProperty(value = "用户头像")
    @Size(max = 100, message = "用户头像最大长度要小于 100")
    private String userPhoto;

    /**
     * 用户性别;0-男 1-女
     */
    @TableField(value = "user_sex")
    @ApiModelProperty(value = "用户性别;0-男 1-女")
    private Byte userSex;

    /**
     * 账户余额
     */
    @TableField(value = "account_balance")
    @ApiModelProperty(value = "账户余额")
    @NotNull(message = "账户余额不能为null")
    private Long accountBalance;

    /**
     * 用户状态;0-正常
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "用户状态;0-正常")
    @NotNull(message = "用户状态;0-正常不能为null")
    private Byte status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}