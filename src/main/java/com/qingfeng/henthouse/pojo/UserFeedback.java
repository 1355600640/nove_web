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
 * 用户反馈
 */
@ApiModel(description = "用户反馈")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_feedback")
public class UserFeedback implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 反馈用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "反馈用户id")
    @NotNull(message = "反馈用户id不能为null")
    private Long userId;

    /**
     * 反馈内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "反馈内容")
    @Size(max = 512, message = "反馈内容最大长度要小于 512")
    @NotBlank(message = "反馈内容不能为空")
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