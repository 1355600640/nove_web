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
 * 用户阅读历史
 */
@ApiModel(description = "用户阅读历史")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_read_history")
public class UserReadHistory implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "用户ID不能为null")
    private Long userId;

    /**
     * 小说ID
     */
    @TableField(value = "book_id")
    @ApiModelProperty(value = "小说ID")
    @NotNull(message = "小说ID不能为null")
    private Long bookId;

    /**
     * 上一次阅读的章节内容表ID
     */
    @TableField(value = "pre_content_id")
    @ApiModelProperty(value = "上一次阅读的章节内容表ID")
    @NotNull(message = "上一次阅读的章节内容表ID不能为null")
    private Long preContentId;

    /**
     * 创建时间;
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间;")
    private Date createTime;

    /**
     * 更新时间;
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间;")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}