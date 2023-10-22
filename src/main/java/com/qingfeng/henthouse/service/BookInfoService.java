package com.qingfeng.henthouse.service;

import com.qingfeng.henthouse.Dto.BookChapterDto;
import com.qingfeng.henthouse.Dto.BookInfoDto;
import com.qingfeng.henthouse.pojo.BookChapter;

import java.util.List;

public interface BookInfoService {

    /**
     * 获取书本详情
     * @param id 书本id
     * @return
     */
    public BookInfoDto getBookInfo(String id);

    /**
     * 获取书本目录
     * @param id
     * @return
     */
    public List<BookChapter> getBookChapterList(String id);

    /**
     * 获取小说章节内容
     * @param id 书本id
     * @param page 页码
     * @return
     */
    public BookChapterDto getBookChapter(String id,String page,String chapterId);
}
