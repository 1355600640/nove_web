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

@ApiModel(description="sys_user_authority")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user_authority")
public class SysUserAuthority implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    @NotNull(message = "不能为null")
    private Integer id;

    /**
     * 关联权限表id
     */
    @TableField(value = "authority_id")
    @ApiModelProperty(value="关联权限表id")
    private Integer authorityId;

    /**
     * 关联用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="关联用户id")
    private Integer userId;

    private static final long serialVersionUID = 1L;
}