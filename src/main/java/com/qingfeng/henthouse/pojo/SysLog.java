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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 */
@ApiModel(description = "系统日志")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_log")
public class SysLog implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    @Size(max = 50, message = "用户名最大长度要小于 50")
    private String username;

    /**
     * 用户操作
     */
    @TableField(value = "`operation`")
    @ApiModelProperty(value = "用户操作")
    @Size(max = 50, message = "用户操作最大长度要小于 50")
    private String operation;

    /**
     * 响应时间
     */
    @TableField(value = "`time`")
    @ApiModelProperty(value = "响应时间")
    private Integer time;

    /**
     * 请求方法
     */
    @TableField(value = "`method`")
    @ApiModelProperty(value = "请求方法")
    @Size(max = 200, message = "请求方法最大长度要小于 200")
    private String method;

    /**
     * 请求参数
     */
    @TableField(value = "params")
    @ApiModelProperty(value = "请求参数")
    @Size(max = 5000, message = "请求参数最大长度要小于 5000")
    private String params;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "IP地址")
    @Size(max = 64, message = "IP地址最大长度要小于 64")
    private String ip;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}