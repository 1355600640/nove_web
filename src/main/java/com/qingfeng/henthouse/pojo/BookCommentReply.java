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
 * 小说评论回复
 */
@ApiModel(description = "小说评论回复")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_comment_reply")
public class BookCommentReply implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 评论ID
     */
    @TableField(value = "comment_id")
    @ApiModelProperty(value = "评论ID")
    @NotNull(message = "评论ID不能为null")
    private Long commentId;

    /**
     * 回复用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "回复用户ID")
    @NotNull(message = "回复用户ID不能为null")
    private Long userId;

    /**
     * 回复内容
     */
    @TableField(value = "reply_content")
    @ApiModelProperty(value = "回复内容")
    @Size(max = 512, message = "回复内容最大长度要小于 512")
    @NotBlank(message = "回复内容不能为空")
    private String replyContent;

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