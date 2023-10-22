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
 * 小说内容
 */
@ApiModel(description = "小说内容")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_content")
public class BookContent implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 章节ID
     */
    @TableField(value = "chapter_id")
    @ApiModelProperty(value = "章节ID")
    @NotNull(message = "章节ID不能为null")
    private Long chapterId;

    /**
     * 小说章节内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "小说章节内容")
    @NotBlank(message = "小说章节内容不能为空")
    private String content;

    @TableField(value = "create_time")
    @ApiModelProperty(value = "")
    private Date createTime;

    @TableField(value = "update_time")
    @ApiModelProperty(value = "")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}