package com.qingfeng.henthouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qingfeng.henthouse.Dto.BookChapterDto;
import com.qingfeng.henthouse.Dto.BookInfoDto;
import com.qingfeng.henthouse.mapper.AuthorInfoMapper;
import com.qingfeng.henthouse.mapper.BookChapterMapper;
import com.qingfeng.henthouse.mapper.BookContentMapper;
import com.qingfeng.henthouse.mapper.BookInfoMapper;
import com.qingfeng.henthouse.pojo.AuthorInfo;
import com.qingfeng.henthouse.pojo.BookChapter;
import com.qingfeng.henthouse.pojo.BookContent;
import com.qingfeng.henthouse.pojo.BookInfo;
import com.qingfeng.henthouse.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    BookInfoMapper bookInfoMapper;

    @Autowired
    AuthorInfoMapper authorInfoMapper;

    @Autowired
    BookChapterMapper  bookChapterMapper;

    @Autowired
    BookContentMapper bookContentMapper;

    @Override
    public BookInfoDto getBookInfo(String id) {
        // 获取书本详情
        LambdaQueryWrapper<BookInfo> bookInfoWrapper = new LambdaQueryWrapper<>();
        bookInfoWrapper.eq(BookInfo::getId,id);
        BookInfo bookInfo = bookInfoMapper.selectOne(bookInfoWrapper);
        // 获取作者信息
        LambdaQueryWrapper<AuthorInfo> authorInfoWrapper = new LambdaQueryWrapper<>();
        authorInfoWrapper.eq(AuthorInfo::getId,bookInfo.getAuthorId());
        AuthorInfo authorInfo = authorInfoMapper.selectOne(authorInfoWrapper);
        // 获取第一章节内容
        LambdaQueryWrapper<BookChapter> bookChapterWrapper = new LambdaQueryWrapper<>();
        bookChapterWrapper.eq(BookChapter::getBookId,id).eq(BookChapter::getChapterNum,0);
        BookChapter bookChapter = bookChapterMapper.selectOne(bookChapterWrapper);
        LambdaQueryWrapper<BookContent> bookContentWrapper = new LambdaQueryWrapper<>();
        bookContentWrapper.eq(BookContent::getChapterId,bookChapter.getId());
        BookContent bookContent = bookContentMapper.selectOne(bookContentWrapper);
        // TODO 获取最近阅读记录
        // TODO 查询用户是否关注作者
        BookInfoDto bookInfoDto = BookInfoDto.builder().authorInfo(authorInfo)
                .bookInfo(bookInfo)
                .fristPageName(bookChapter.getChapterName())
                .fristPageContent(bookContent.getContent()).build();
        return bookInfoDto;
    }

    @Override
    public List<BookChapter> getBookChapterList(String id) {
        // 获取所有目录
        LambdaQueryWrapper<BookChapter> bookAllChapterWrapper = new LambdaQueryWrapper<>();
        bookAllChapterWrapper.eq(BookChapter::getBookId,id);
        List<BookChapter> bookChapters = bookChapterMapper.selectList(bookAllChapterWrapper);
        return bookChapters;
    }

    @Override
    public BookChapterDto getBookChapter(String id,String page,String chapterId) {
        LambdaQueryWrapper<BookChapter> bookChapterWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(chapterId)){
            bookChapterWrapper.eq(BookChapter::getId,chapterId);
        }else {
            bookChapterWrapper.eq(BookChapter::getBookId,id)
                    .eq(BookChapter::getChapterNum,page);
        }
        BookChapter bookChapter = bookChapterMapper.selectOne(bookChapterWrapper);
        LambdaQueryWrapper<BookContent> bookContentWrapper = new LambdaQueryWrapper<>();
        bookContentWrapper.eq(BookContent::getChapterId,bookChapter.getId());
        BookContent bookContent = bookContentMapper.selectOne(bookContentWrapper);
        // 获取书本信息
        LambdaQueryWrapper<BookInfo> bookInfoWrapper = new LambdaQueryWrapper<>();
        bookInfoWrapper.eq(BookInfo::getId,id);
        BookInfo bookInfo = bookInfoMapper.selectOne(bookInfoWrapper);
        // 获取小说总章节数
        bookChapterWrapper = new LambdaQueryWrapper<>();
        bookChapterWrapper.eq(BookChapter::getBookId,id);
        Long chapterNum = bookChapterMapper.selectCount(bookChapterWrapper);
        // TODO 登录之后添加阅读记录
        BookChapterDto bookChapterDto = BookChapterDto.builder().bookChapter(bookChapter)
                .content(bookContent.getContent())
                .bookInfo(bookInfo)
                .chapterNum(chapterNum).build();
        return bookChapterDto;
    }
}
