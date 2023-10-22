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
 * 微信支付
 */
@ApiModel(description = "微信支付")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "pay_wechat")
public class PayWechat implements Serializable {
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
    @Size(max = 32, message = "商户订单号最大长度要小于 32")
    @NotBlank(message = "商户订单号不能为空")
    private String outTradeNo;

    /**
     * 微信支付订单号
     */
    @TableField(value = "transaction_id")
    @ApiModelProperty(value = "微信支付订单号")
    @Size(max = 32, message = "微信支付订单号最大长度要小于 32")
    @NotBlank(message = "微信支付订单号不能为空")
    private String transactionId;

    /**
     * 交易类型;JSAPI-公众号支付 NATIVE-扫码支付 APP-APP支付 MICROPAY-付款码支付 MWEB-H5支付 FACEPAY-刷脸支付
     */
    @TableField(value = "trade_type")
    @ApiModelProperty(value = "交易类型;JSAPI-公众号支付 NATIVE-扫码支付 APP-APP支付 MICROPAY-付款码支付 MWEB-H5支付 FACEPAY-刷脸支付")
    @Size(max = 16, message = "交易类型;JSAPI-公众号支付 NATIVE-扫码支付 APP-APP支付 MICROPAY-付款码支付 MWEB-H5支付 FACEPAY-刷脸支付最大长度要小于 16")
    private String tradeType;

    /**
     * 交易状态;SUCCESS-支付成功 REFUND-转入退款 NOTPAY-未支付 CLOSED-已关闭 REVOKED-已撤销（付款码支付） USERPAYING-用户支付中（付款码支付） PAYERROR-支付失败(其他原因，如银行返回失败)
     */
    @TableField(value = "trade_state")
    @ApiModelProperty(value = "交易状态;SUCCESS-支付成功 REFUND-转入退款 NOTPAY-未支付 CLOSED-已关闭 REVOKED-已撤销（付款码支付） USERPAYING-用户支付中（付款码支付） PAYERROR-支付失败(其他原因，如银行返回失败)")
    @Size(max = 32, message = "交易状态;SUCCESS-支付成功 REFUND-转入退款 NOTPAY-未支付 CLOSED-已关闭 REVOKED-已撤销（付款码支付） USERPAYING-用户支付中（付款码支付） PAYERROR-支付失败(其他原因，如银行返回失败)最大长度要小于 32")
    private String tradeState;

    /**
     * 交易状态描述
     */
    @TableField(value = "trade_state_desc")
    @ApiModelProperty(value = "交易状态描述")
    @Size(max = 255, message = "交易状态描述最大长度要小于 255")
    private String tradeStateDesc;

    /**
     * 订单总金额;单位：分
     */
    @TableField(value = "amount")
    @ApiModelProperty(value = "订单总金额;单位：分")
    @NotNull(message = "订单总金额;单位：分不能为null")
    private Integer amount;

    /**
     * 用户支付金额;单位：分
     */
    @TableField(value = "payer_total")
    @ApiModelProperty(value = "用户支付金额;单位：分")
    private Integer payerTotal;

    /**
     * 支付完成时间
     */
    @TableField(value = "success_time")
    @ApiModelProperty(value = "支付完成时间")
    private Date successTime;

    /**
     * 支付者用户标识;用户在直连商户appid下的唯一标识
     */
    @TableField(value = "payer_openid")
    @ApiModelProperty(value = "支付者用户标识;用户在直连商户appid下的唯一标识")
    @Size(max = 128, message = "支付者用户标识;用户在直连商户appid下的唯一标识最大长度要小于 128")
    private String payerOpenid;

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