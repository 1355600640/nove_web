package com.qingfeng.henthouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingfeng.henthouse.pojo.Announcement;
import org.apache.ibatis.annotations.Mapper;

/**
* @author HASEE
* @description 针对表【announcement(网站公告)】的数据库操作Mapper
* @createDate 2023-09-25 17:42:30
* @Entity com.qingfeng.henthouse.pojo.Announcement
*/
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

}




