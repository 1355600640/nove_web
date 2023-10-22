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
import java.time.LocalDateTime;

/**
 * 小说章节
 */
@ApiModel(description = "小说章节")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_chapter")
public class BookChapter implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "")
    @NotNull(message = "不能为null")
    private Long id;

    /**
     * 小说ID
     */
    @TableField(value = "book_id")
    @ApiModelProperty(value = "小说ID")
    @NotNull(message = "小说ID不能为null")
    private Long bookId;

    /**
     * 章节号
     */
    @TableField(value = "chapter_num")
    @ApiModelProperty(value = "章节号")
    @NotNull(message = "章节号不能为null")
    private Short chapterNum;

    /**
     * 章节名
     */
    @TableField(value = "chapter_name")
    @ApiModelProperty(value = "章节名")
    @Size(max = 100, message = "章节名最大长度要小于 100")
    @NotBlank(message = "章节名不能为空")
    private String chapterName;

    /**
     * 章节字数
     */
    @TableField(value = "word_count")
    @ApiModelProperty(value = "章节字数")
    @NotNull(message = "章节字数不能为null")
    private Integer wordCount;

    /**
     * 是否收费;1-收费 0-免费
     */
    @TableField(value = "is_vip")
    @ApiModelProperty(value = "是否收费;1-收费 0-免费")
    @NotNull(message = "是否收费;1-收费 0-免费不能为null")
    private Byte isVip;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    private static final long serialVersionUID = 1L;
}