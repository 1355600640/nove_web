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
 * 新闻信息
 */
@ApiModel(description = "新闻信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "news_info")
public class NewsInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 类别ID
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value = "类别ID")
    @NotNull(message = "类别ID不能为null")
    private Long categoryId;

    /**
     * 类别名
     */
    @TableField(value = "category_name")
    @ApiModelProperty(value = "类别名")
    @Size(max = 50, message = "类别名最大长度要小于 50")
    @NotBlank(message = "类别名不能为空")
    private String categoryName;

    /**
     * 新闻来源
     */
    @TableField(value = "source_name")
    @ApiModelProperty(value = "新闻来源")
    @Size(max = 50, message = "新闻来源最大长度要小于 50")
    @NotBlank(message = "新闻来源不能为空")
    private String sourceName;

    /**
     * 新闻标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "新闻标题")
    @Size(max = 100, message = "新闻标题最大长度要小于 100")
    @NotBlank(message = "新闻标题不能为空")
    private String title;

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