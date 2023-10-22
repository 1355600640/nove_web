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
 * 用户评论
 */
@ApiModel(description = "用户评论")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_comment")
public class UserComment implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 评论用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "评论用户ID")
    @NotNull(message = "评论用户ID不能为null")
    private Long userId;

    /**
     * 评论小说ID
     */
    @TableField(value = "book_id")
    @ApiModelProperty(value = "评论小说ID")
    @NotNull(message = "评论小说ID不能为null")
    private Long bookId;

    /**
     * 评价内容
     */
    @TableField(value = "comment_content")
    @ApiModelProperty(value = "评价内容")
    @Size(max = 512, message = "评价内容最大长度要小于 512")
    @NotBlank(message = "评价内容不能为空")
    private String commentContent;

    /**
     * 回复数量
     */
    @TableField(value = "reply_count")
    @ApiModelProperty(value = "回复数量")
    @NotNull(message = "回复数量不能为null")
    private Integer replyCount;

    /**
     * 审核状态;0-待审核 1-审核通过 2-审核不通过
     */
    @TableField(value = "audit_status")
    @ApiModelProperty(value = "审核状态;0-待审核 1-审核通过 2-审核不通过")
    @NotNull(message = "审核状态;0-待审核 1-审核通过 2-审核不通过不能为null")
    private Byte auditStatus;

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