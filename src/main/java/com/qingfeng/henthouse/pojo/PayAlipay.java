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
 * 支付宝支付
 */
@ApiModel(description = "支付宝支付")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "pay_alipay")
public class PayAlipay implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 商户订单号
     */
    @TableField(value = "out_trade_no")
    @ApiModelProperty(value = "商户订单号")
    @Size(max = 64, message = "商户订单号最大长度要小于 64")
    @NotBlank(message = "商户订单号不能为空")
    private String outTradeNo;

    /**
     * 支付宝交易号
     */
    @TableField(value = "trade_no")
    @ApiModelProperty(value = "支付宝交易号")
    @Size(max = 64, message = "支付宝交易号最大长度要小于 64")
    @NotBlank(message = "支付宝交易号不能为空")
    private String tradeNo;

    /**
     * 买家支付宝账号 ID
     */
    @TableField(value = "buyer_id")
    @ApiModelProperty(value = "买家支付宝账号 ID")
    @Size(max = 16, message = "买家支付宝账号 ID最大长度要小于 16")
    private String buyerId;

    /**
     * 交易状态;TRADE_SUCCESS-交易成功
     */
    @TableField(value = "trade_status")
    @ApiModelProperty(value = "交易状态;TRADE_SUCCESS-交易成功")
    @Size(max = 32, message = "交易状态;TRADE_SUCCESS-交易成功最大长度要小于 32")
    private String tradeStatus;

    /**
     * 订单金额;单位：分
     */
    @TableField(value = "total_amount")
    @ApiModelProperty(value = "订单金额;单位：分")
    @NotNull(message = "订单金额;单位：分不能为null")
    private Integer totalAmount;

    /**
     * 实收金额;单位：分
     */
    @TableField(value = "receipt_amount")
    @ApiModelProperty(value = "实收金额;单位：分")
    private Integer receiptAmount;

    /**
     * 开票金额
     */
    @TableField(value = "invoice_amount")
    @ApiModelProperty(value = "开票金额")
    private Integer invoiceAmount;

    /**
     * 交易创建时间
     */
    @TableField(value = "gmt_create")
    @ApiModelProperty(value = "交易创建时间")
    private Date gmtCreate;

    /**
     * 交易付款时间
     */
    @TableField(value = "gmt_payment")
    @ApiModelProperty(value = "交易付款时间")
    private Date gmtPayment;

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