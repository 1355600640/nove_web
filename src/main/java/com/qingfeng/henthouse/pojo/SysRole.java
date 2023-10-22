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
 * 角色
 */
@ApiModel(description = "角色")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role")
public class SysRole implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    @ApiModelProperty(value = "角色名称")
    @Size(max = 100, message = "角色名称最大长度要小于 100")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色标识
     */
    @TableField(value = "role_sign")
    @ApiModelProperty(value = "角色标识")
    @Size(max = 100, message = "角色标识最大长度要小于 100")
    private String roleSign;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    @Size(max = 100, message = "备注最大长度要小于 100")
    private String remark;

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