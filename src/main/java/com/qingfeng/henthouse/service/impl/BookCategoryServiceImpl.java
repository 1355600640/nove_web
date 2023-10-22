package com.qingfeng.henthouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qingfeng.henthouse.mapper.BookCategoryMapper;
import com.qingfeng.henthouse.pojo.BookCategory;
import com.qingfeng.henthouse.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    BookCategoryMapper categoryMapper;

    @Cacheable(cacheNames = "qingfeng-novel",key = "'bookCategory'")
    @Override
    public List<BookCategory> getCategories() {
        LambdaQueryWrapper<BookCategory> categoryLambdaQueryWrapper = new LambdaQueryWrapper<BookCategory>();
        List<BookCategory> bookCategories = categoryMapper.selectList(categoryLambdaQueryWrapper);
        return bookCategories;
    }
}
