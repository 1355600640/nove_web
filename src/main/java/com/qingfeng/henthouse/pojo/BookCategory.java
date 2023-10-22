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
 * 小说类别
 */
@ApiModel(description = "小说类别")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_category")
public class BookCategory implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 作品方向;0-男频 1-女频
     */
    @TableField(value = "work_direction")
    @ApiModelProperty(value = "作品方向;0-男频 1-女频")
    @NotNull(message = "作品方向;0-男频 1-女频不能为null")
    private Byte workDirection;

    /**
     * 类别名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value = "类别名")
    @Size(max = 20, message = "类别名最大长度要小于 20")
    @NotBlank(message = "类别名不能为空")
    private String name;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value = "排序")
    @NotNull(message = "排序不能为null")
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