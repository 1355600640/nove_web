package com.qingfeng.henthouse.Dto;


import com.qingfeng.henthouse.pojo.BookChapter;
import com.qingfeng.henthouse.pojo.BookInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@ApiModel("章节信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookChapterDto {

    @ApiModelProperty(value = "章节信息")
    private BookChapter bookChapter;

    @ApiModelProperty(value = "章节内容")
    private String content;

    @ApiModelProperty(value = "小说书本信息")
    private BookInfo bookInfo;

    @ApiModelProperty(value = "总章节数")
    private Long chapterNum;
}
