package com.qingfeng.henthouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 小说推荐
 */
@ApiModel(description = "小说推荐")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "home_book")
public class HomeBook implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 推荐类型;0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "推荐类型;0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐")
    @NotNull(message = "推荐类型;0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐不能为null")
    private int type;

    /**
     * 推荐排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value = "推荐排序")
    @NotNull(message = "推荐排序不能为null")
    private int sort;

    /**
     * 推荐小说ID
     */
    @TableField(value = "book_id")
    @ApiModelProperty(value = "推荐小说ID")
    @NotNull(message = "推荐小说ID不能为null")
    private Long bookId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}