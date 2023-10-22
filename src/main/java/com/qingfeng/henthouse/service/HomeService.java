package com.qingfeng.henthouse.service;

import com.qingfeng.henthouse.Dto.BookInfoAddNumDto;
import com.qingfeng.henthouse.pojo.Announcement;
import com.qingfeng.henthouse.pojo.BookInfo;

import java.util.List;
import java.util.Map;

public interface HomeService {

    /**
     * 根据类型获取首页推荐内容
     * @param type
     * @return
     */
    public List<BookInfo> recommend(String type);

    /**
     * 获取榜单
     * @param type 类型
     * @param num 数目
     * @return
     */
    public List<BookInfo> ranking(String type,Integer num);

    /**
     * 最近更新书籍
     * @param type 小说类型
     * @param mode 最近更新/完本
     * @return
     */
    public List<BookInfoAddNumDto> lastLpdateBook(String type, int mode);

    /**
     * 获取系统最新公告
     * @return
     */
    public List<Announcement> getAnnouncement();
}
