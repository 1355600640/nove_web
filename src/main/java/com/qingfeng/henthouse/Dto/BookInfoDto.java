package com.qingfeng.henthouse.Dto;

import com.qingfeng.henthouse.pojo.AuthorInfo;
import com.qingfeng.henthouse.pojo.BookInfo;
import com.qingfeng.henthouse.pojo.UserReadHistory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("书本详情")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookInfoDto {
    @ApiModelProperty("书本详情")
    private BookInfo bookInfo;

    @ApiModelProperty("书本第一章名字")
    private String fristPageName;

    @ApiModelProperty("书本第一章内容")
    private String fristPageContent;

    @ApiModelProperty("作者信息")
    private AuthorInfo authorInfo;

    @ApiModelProperty("最近阅读记录")
    private UserReadHistory userReadHistory;

}
