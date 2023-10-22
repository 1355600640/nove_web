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
 * 友情链接
 */
@ApiModel(description = "友情链接")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "home_friend_link")
public class HomeFriendLink implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 链接名
     */
    @TableField(value = "link_name")
    @ApiModelProperty(value = "链接名")
    @Size(max = 50, message = "链接名最大长度要小于 50")
    @NotBlank(message = "链接名不能为空")
    private String linkName;

    /**
     * 链接url
     */
    @TableField(value = "link_url")
    @ApiModelProperty(value = "链接url")
    @Size(max = 100, message = "链接url最大长度要小于 100")
    @NotBlank(message = "链接url不能为空")
    private String linkUrl;

    /**
     * 排序号
     */
    @TableField(value = "sort")
    @ApiModelProperty(value = "排序号")
    @NotNull(message = "排序号不能为null")
    private Byte sort;

    /**
     * 是否开启;0-不开启 1-开启
     */
    @TableField(value = "is_open")
    @ApiModelProperty(value = "是否开启;0-不开启 1-开启")
    @NotNull(message = "是否开启;0-不开启 1-开启不能为null")
    private Byte isOpen;

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