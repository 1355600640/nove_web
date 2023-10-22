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
import java.io.Serializable;
import java.util.Date;

/**
 * 新闻内容
 */
@ApiModel(description = "新闻内容")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "news_content")
public class NewsContent implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 新闻ID
     */
    @TableField(value = "news_id")
    @ApiModelProperty(value = "新闻ID")
    @NotNull(message = "新闻ID不能为null")
    private Long newsId;

    /**
     * 新闻内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "新闻内容")
    @NotBlank(message = "新闻内容不能为空")
    private String content;

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