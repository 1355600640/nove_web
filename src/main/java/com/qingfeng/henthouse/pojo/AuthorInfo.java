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
 * 作者信息
 */
@ApiModel(description = "作者信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "author_info")
public class AuthorInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "用户ID不能为null")
    private Long userId;

    /**
     * 邀请码
     */
    @TableField(value = "invite_code")
    @ApiModelProperty(value = "邀请码")
    @Size(max = 20, message = "邀请码最大长度要小于 20")
    @NotBlank(message = "邀请码不能为空")
    private String inviteCode;

    /**
     * 笔名
     */
    @TableField(value = "pen_name")
    @ApiModelProperty(value = "笔名")
    @Size(max = 20, message = "笔名最大长度要小于 20")
    @NotBlank(message = "笔名不能为空")
    private String penName;

    /**
     * 手机号码
     */
    @TableField(value = "tel_phone")
    @ApiModelProperty(value = "手机号码")
    @Size(max = 20, message = "手机号码最大长度要小于 20")
    private String telPhone;

    /**
     * QQ或微信账号
     */
    @TableField(value = "chat_account")
    @ApiModelProperty(value = "QQ或微信账号")
    @Size(max = 50, message = "QQ或微信账号最大长度要小于 50")
    private String chatAccount;

    /**
     * 电子邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "电子邮箱")
    @Size(max = 50, message = "电子邮箱最大长度要小于 50")
    private String email;

    /**
     * 作品方向;0-男频 1-女频
     */
    @TableField(value = "work_direction")
    @ApiModelProperty(value = "作品方向;0-男频 1-女频")
    private Byte workDirection;

    /**
     * 0：正常;1-封禁
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "0：正常;1-封禁")
    @NotNull(message = "0：正常;1-封禁不能为null")
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