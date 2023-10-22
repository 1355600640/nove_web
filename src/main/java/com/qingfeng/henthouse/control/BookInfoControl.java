package com.qingfeng.henthouse.control;


import com.qingfeng.henthouse.Dto.BookChapterDto;
import com.qingfeng.henthouse.Dto.BookInfoDto;
import com.qingfeng.henthouse.common.ApiResponseObject;
import com.qingfeng.henthouse.pojo.BookChapter;
import com.qingfeng.henthouse.service.BookInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "书本信息")
@RestController
@RequestMapping("/bookInfo")
public class BookInfoControl {

    @Autowired
    BookInfoService bookInfoService;

    @ApiOperation(value = "获取书本详情信息")
    @GetMapping("/getBookInfo")
    public ApiResponseObject<BookInfoDto> getBookInfo(String id){
        if(StringUtils.isEmpty(id)){
            throw new RuntimeException("参数错误");
        }
        BookInfoDto bookInfo = bookInfoService.getBookInfo(id);
        return ApiResponseObject.success(bookInfo);
    }

    @ApiOperation(value = "获取书本目录")
    @GetMapping(value = "/getCatalogue")
    public ApiResponseObject<List<BookChapter>> getCatalogue( String id){
        if(StringUtils.isEmpty(id)){
            throw new RuntimeException("参数错误");
        }
        List<BookChapter> bookChapterList = bookInfoService.getBookChapterList(id);
        return ApiResponseObject.success(bookChapterList);
    }

    @ApiOperation(value = "获取书本详情")
    @GetMapping(value = "/getChapter")
    public ApiResponseObject<BookChapterDto> getChapter(String id,String page,String chapterId){
        if(Strings.isEmpty(id)||Strings.isEmpty(page)){
            throw new RuntimeException("参数错误");
        }
        BookChapterDto bookChapter = bookInfoService.getBookChapter(id, page,chapterId);
        return ApiResponseObject.success(bookChapter);
    }
}
