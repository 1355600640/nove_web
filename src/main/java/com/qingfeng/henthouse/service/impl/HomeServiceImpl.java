package com.qingfeng.henthouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qingfeng.henthouse.Dto.BookInfoAddNumDto;
import com.qingfeng.henthouse.mapper.AnnouncementMapper;
import com.qingfeng.henthouse.mapper.BookInfoMapper;
import com.qingfeng.henthouse.mapper.HomeBookMapper;
import com.qingfeng.henthouse.pojo.Announcement;
import com.qingfeng.henthouse.pojo.BookChapter;
import com.qingfeng.henthouse.pojo.BookInfo;
import com.qingfeng.henthouse.pojo.HomeBook;
import com.qingfeng.henthouse.service.HomeService;
import com.qingfeng.henthouse.utils.RedisCache;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {



    @Autowired
    private HomeBookMapper homeBookMapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Autowired
    private RedisCache redisCache;

    // 根据类型查询书本并根据推荐排序
    @Cacheable(cacheNames = "qingfeng-novel",key = "'recommend:'+#type")
    @Override
    public List<BookInfo> recommend(String type) {
        LambdaQueryWrapper<HomeBook> homeBookWrapper = new LambdaQueryWrapper<HomeBook>();
        homeBookWrapper.eq(HomeBook::getType,type)
                .orderByDesc(HomeBook::getSort);
        List<Long> bookIds = homeBookMapper.selectList(homeBookWrapper)
                .stream().map(HomeBook::getBookId)
                .collect(Collectors.toList());
        LambdaQueryWrapper<BookInfo> bookInfoWrapper = new LambdaQueryWrapper<BookInfo>();
        bookInfoWrapper.in(BookInfo::getId,bookIds);
        List<BookInfo> bookInfos = bookInfoMapper.selectList(bookInfoWrapper);
        return bookInfos;
    }

    // 榜单
    @Cacheable(cacheNames = "qingfeng-novel-ranking",key = "'ranking:'+#type")
    @Override
    public List<BookInfo> ranking(String type,Integer num) {
        List<BookInfo> bookInfos = new ArrayList<>();
        switch (type) {
            case "0": bookInfos = bookInfoMapper.clickRanking(num);break;
            case "1": bookInfos = bookInfoMapper.newBookRanking(num);break;
            case "2": bookInfos = bookInfoMapper.renewalRanking(num);break;
        }
        return bookInfos;
    }

    @Cacheable(cacheNames = "qingfeng-novel",key = "'lastLpdateBook:'+#type+'-'+#mode")
    @Override
    public List<BookInfoAddNumDto> lastLpdateBook(String type, int mode) {
        List<BookInfoAddNumDto> bookInfoAddNumDtos = bookInfoMapper.selectBookInfo(15, type, mode);
        return bookInfoAddNumDtos;
    }

    @Cacheable(cacheNames = "qingfeng-novel",key = "'announcement'")
    @Override
    public List<Announcement> getAnnouncement() {
        Page<Announcement> page = new Page<>(0, 10);
        LambdaQueryWrapper<Announcement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Announcement::getCreateTime);
        announcementMapper.selectPage(page,queryWrapper);
        List<Announcement> announcements = page.getRecords();
        return announcements;
    }
}
