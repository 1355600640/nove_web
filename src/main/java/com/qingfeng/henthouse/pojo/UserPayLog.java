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
 * 用户充值记录
 */
@ApiModel(description = "用户充值记录")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_pay_log")
public class UserPayLog implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 充值用户ID
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "充值用户ID")
    @NotNull(message = "充值用户ID不能为null")
    private Long userId;

    /**
     * 充值方式;0-支付宝 1-微信
     */
    @TableField(value = "pay_channel")
    @ApiModelProperty(value = "充值方式;0-支付宝 1-微信")
    @NotNull(message = "充值方式;0-支付宝 1-微信不能为null")
    private Byte payChannel;

    /**
     * 商户订单号
     */
    @TableField(value = "out_trade_no")
    @ApiModelProperty(value = "商户订单号")
    @Size(max = 64, message = "商户订单号最大长度要小于 64")
    @NotBlank(message = "商户订单号不能为空")
    private String outTradeNo;

    /**
     * 充值金额;单位：分
     */
    @TableField(value = "amount")
    @ApiModelProperty(value = "充值金额;单位：分")
    @NotNull(message = "充值金额;单位：分不能为null")
    private Integer amount;

    /**
     * 充值商品类型;0-屋币 1-包年VIP
     */
    @TableField(value = "product_type")
    @ApiModelProperty(value = "充值商品类型;0-屋币 1-包年VIP")
    @NotNull(message = "充值商品类型;0-屋币 1-包年VIP不能为null")
    private Byte productType;

    /**
     * 充值商品ID
     */
    @TableField(value = "product_id")
    @ApiModelProperty(value = "充值商品ID")
    private Long productId;

    /**
     * 充值商品名;示例值：屋币
     */
    @TableField(value = "product_name")
    @ApiModelProperty(value = "充值商品名;示例值：屋币")
    @Size(max = 255, message = "充值商品名;示例值：屋币最大长度要小于 255")
    @NotBlank(message = "充值商品名;示例值：屋币不能为空")
    private String productName;

    /**
     * 充值商品值;示例值：255
     */
    @TableField(value = "product_value")
    @ApiModelProperty(value = "充值商品值;示例值：255")
    private Integer productValue;

    /**
     * 充值时间
     */
    @TableField(value = "pay_time")
    @ApiModelProperty(value = "充值时间")
    @NotNull(message = "充值时间不能为null")
    private Date payTime;

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