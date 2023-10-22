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
 * 小说信息
 */
@ApiModel(description = "小说信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_info")
public class BookInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为null")
    private Long id;

    /**
     * 作品方向;0-男频 1-女频
     */
    @TableField(value = "work_direction")
    @ApiModelProperty(value = "作品方向;0-男频 1-女频")
    private Byte workDirection;

    /**
     * 类别ID
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value = "类别ID")
    private Long categoryId;

    /**
     * 类别名
     */
    @TableField(value = "category_name")
    @ApiModelProperty(value = "类别名")
    @Size(max = 50, message = "类别名最大长度要小于 50")
    private String categoryName;

    /**
     * 小说封面地址
     */
    @TableField(value = "pic_url")
    @ApiModelProperty(value = "小说封面地址")
    @Size(max = 200, message = "小说封面地址最大长度要小于 200")
    @NotBlank(message = "小说封面地址不能为空")
    private String picUrl;

    /**
     * 小说名
     */
    @TableField(value = "book_name")
    @ApiModelProperty(value = "小说名")
    @Size(max = 50, message = "小说名最大长度要小于 50")
    @NotBlank(message = "小说名不能为空")
    private String bookName;

    /**
     * 作家id
     */
    @TableField(value = "author_id")
    @ApiModelProperty(value = "作家id")
    @NotNull(message = "作家id不能为null")
    private Long authorId;

    /**
     * 作家名
     */
    @TableField(value = "author_name")
    @ApiModelProperty(value = "作家名")
    @Size(max = 50, message = "作家名最大长度要小于 50")
    @NotBlank(message = "作家名不能为空")
    private String authorName;

    /**
     * 书籍描述
     */
    @TableField(value = "book_desc")
    @ApiModelProperty(value = "书籍描述")
    @Size(max = 2000, message = "书籍描述最大长度要小于 2000")
    @NotBlank(message = "书籍描述不能为空")
    private String bookDesc;

    /**
     * 评分;总分:10 ，真实评分 = score/10
     */
    @TableField(value = "score")
    @ApiModelProperty(value = "评分;总分:10 ，真实评分 = score/10")
    @NotNull(message = "评分;总分:10 ，真实评分 = score/10不能为null")
    private Byte score;

    /**
     * 书籍状态;0-连载中 1-已完结
     */
    @TableField(value = "book_status")
    @ApiModelProperty(value = "书籍状态;0-连载中 1-已完结")
    @NotNull(message = "书籍状态;0-连载中 1-已完结不能为null")
    private Byte bookStatus;

    /**
     * 点击量
     */
    @TableField(value = "visit_count")
    @ApiModelProperty(value = "点击量")
    @NotNull(message = "点击量不能为null")
    private Long visitCount;

    /**
     * 总字数
     */
    @TableField(value = "word_count")
    @ApiModelProperty(value = "总字数")
    @NotNull(message = "总字数不能为null")
    private Integer wordCount;

    /**
     * 评论数
     */
    @TableField(value = "comment_count")
    @ApiModelProperty(value = "评论数")
    @NotNull(message = "评论数不能为null")
    private Integer commentCount;

    /**
     * 最新章节ID
     */
    @TableField(value = "last_chapter_id")
    @ApiModelProperty(value = "最新章节ID")
    private Long lastChapterId;

    /**
     * 最新章节名
     */
    @TableField(value = "last_chapter_name")
    @ApiModelProperty(value = "最新章节名")
    @Size(max = 50, message = "最新章节名最大长度要小于 50")
    private String lastChapterName;

    /**
     * 最新章节更新时间
     */
    @TableField(value = "last_chapter_update_time")
    @ApiModelProperty(value = "最新章节更新时间")
    private Date lastChapterUpdateTime;

    /**
     * 是否收费;1-收费 0-免费
     */
    @TableField(value = "is_vip")
    @ApiModelProperty(value = "是否收费;1-收费 0-免费")
    @NotNull(message = "是否收费;1-收费 0-免费不能为null")
    private Byte isVip;

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