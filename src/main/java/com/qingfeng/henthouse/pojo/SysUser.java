package com.qingfeng.henthouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 */
@ApiModel(description = "系统用户")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    @Size(max = 50, message = "用户名最大长度要小于 50")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码")
    @Size(max = 50, message = "密码最大长度要小于 50")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 真实姓名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "真实姓名")
    @Size(max = 100, message = "真实姓名最大长度要小于 100")
    private String name;

    /**
     * 性别;0-男 1-女
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别;0-男 1-女")
    private Byte sex;

    /**
     * 出身日期
     */
    @TableField(value = "birth")
    @ApiModelProperty(value = "出身日期")
    private Date birth;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    @Size(max = 100, message = "邮箱最大长度要小于 100")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    @ApiModelProperty(value = "手机号")
    @Size(max = 100, message = "手机号最大长度要小于 100")
    private String mobile;

    /**
     * 状态;0-禁用 1-正常
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "状态;0-禁用 1-正常")
    @NotNull(message = "状态;0-禁用 1-正常不能为null")
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