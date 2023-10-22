package com.qingfeng.henthouse.control;

import com.qingfeng.henthouse.common.ApiResponseObject;
import com.qingfeng.henthouse.pojo.BookCategory;
import com.qingfeng.henthouse.service.BookCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "书本分类")
@RestController
@RequestMapping("/category")
public class BookCategoryControl {

    @Autowired
    BookCategoryService bookCategoryService;

    @ApiOperation(("获取所有分类"))
    @GetMapping("/getNameAll")
    public ApiResponseObject<List<BookCategory>> getNameAll() {
        return ApiResponseObject.success(bookCategoryService.getCategories());
    }
}
