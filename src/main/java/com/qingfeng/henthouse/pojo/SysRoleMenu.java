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
import java.io.Serializable;
import java.util.Date;

/**
 * 角色与菜单对应关系
 */
@ApiModel(description = "角色与菜单对应关系")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role_menu")
public class SysRoleMenu implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 角色ID
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "角色ID")
    @NotNull(message = "角色ID不能为null")
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id")
    @ApiModelProperty(value = "菜单ID")
    @NotNull(message = "菜单ID不能为null")
    private Long menuId;

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