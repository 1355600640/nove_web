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
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户消费记录
 */
@ApiModel(description = "用户消费记录")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_consume_log")
public class UserConsumeLog implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 消费用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "消费用户ID")
    @NotNull(message = "消费用户ID不能为null")
    private Long userId;

    /**
     * 消费使用的金额;单位：屋币
     */
    @TableField(value = "amount")
    @ApiModelProperty(value = "消费使用的金额;单位：屋币")
    @NotNull(message = "消费使用的金额;单位：屋币不能为null")
    private Integer amount;

    /**
     * 消费商品类型;0-小说VIP章节
     */
    @TableField(value = "product_type")
    @ApiModelProperty(value = "消费商品类型;0-小说VIP章节")
    @NotNull(message = "消费商品类型;0-小说VIP章节不能为null")
    private Byte productType;

    /**
     * 消费的的商品ID;例如：章节ID
     */
    @TableField(value = "product_id")
    @ApiModelProperty(value = "消费的的商品ID;例如：章节ID")
    private Long productId;

    /**
     * 消费的的商品名;例如：章节名
     */
    @TableField(value = "produc_name")
    @ApiModelProperty(value = "消费的的商品名;例如：章节名")
    @Size(max = 50, message = "消费的的商品名;例如：章节名最大长度要小于 50")
    private String producName;

    /**
     * 消费的的商品值;例如：1
     */
    @TableField(value = "produc_value")
    @ApiModelProperty(value = "消费的的商品值;例如：1")
    private Integer producValue;

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