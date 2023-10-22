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
 * 系统菜单
 */
@ApiModel(description = "系统菜单")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
public class SysMenu implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 父菜单ID;一级菜单为0
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value = "父菜单ID;一级菜单为0")
    @NotNull(message = "父菜单ID;一级菜单为0不能为null")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "菜单名称")
    @Size(max = 50, message = "菜单名称最大长度要小于 50")
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    /**
     * 菜单URL
     */
    @TableField(value = "url")
    @ApiModelProperty(value = "菜单URL")
    @Size(max = 200, message = "菜单URL最大长度要小于 200")
    private String url;

    /**
     * 类型;0-目录   1-菜单
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "类型;0-目录   1-菜单")
    @NotNull(message = "类型;0-目录   1-菜单不能为null")
    private Byte type;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    @ApiModelProperty(value = "菜单图标")
    @Size(max = 50, message = "菜单图标最大长度要小于 50")
    private String icon;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    private Byte sort;

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