package com.qingfeng.henthouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qingfeng.henthouse.Dto.BookInfoAddNumDto;
import com.qingfeng.henthouse.pojo.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo> {

    public List<BookInfo> clickRanking(int num);

    public List<BookInfo> newBookRanking(int num);

    public List<BookInfo> renewalRanking(int num);

    public List<BookInfoAddNumDto> selectBookInfo(@Param("page") int page , @Param("type") String type, @Param("mode") int mode);
}