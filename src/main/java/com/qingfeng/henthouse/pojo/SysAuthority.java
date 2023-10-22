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

/**
 * 用户权限表
 */
@ApiModel(description = "用户权限表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_authority")
public class SysAuthority implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Integer id;

    /**
     * 权限类型
     */
    @TableField(value = "authority")
    @ApiModelProperty(value = "权限类型")
    @Size(max = 255, message = "权限类型最大长度要小于 255")
    private String authority;

    /**
     * 权限名称
     */
    @TableField(value = "authority_name")
    @ApiModelProperty(value = "权限名称")
    @Size(max = 255, message = "权限名称最大长度要小于 255")
    private String authorityName;

    private static final long serialVersionUID = 1L;
}