package com.qingfeng.henthouse.control;

import com.qingfeng.henthouse.Dto.BookInfoAddNumDto;
import com.qingfeng.henthouse.common.ApiResponseObject;
import com.qingfeng.henthouse.pojo.Announcement;
import com.qingfeng.henthouse.pojo.BookInfo;
import com.qingfeng.henthouse.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value = "首页")
@RestController
@RequestMapping("/home")
public class HomeControl {

    @Autowired
    private HomeService homeService;


    @GetMapping("/recommend")
    @ApiOperation(value = "获取首页推荐内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "推荐类型;0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐", required = true, dataType = "String", paramType = "query")
    })
    public ApiResponseObject<List<BookInfo>> getBanner(@RequestParam(defaultValue = "0") String type){
        List<BookInfo> recommend = homeService.recommend(type);
        return ApiResponseObject.success(recommend);
    }

    @GetMapping("/ranking")
    @ApiOperation(value = "榜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "榜单类型;0-点击榜单 1-新书榜单 2-更新榜单", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "num", value = "查询条数", required = true, dataType = "String", paramType = "query")
    })
    public ApiResponseObject<List<BookInfo>> getRanking(@RequestParam(defaultValue = "0") String type,@RequestParam(defaultValue = "10")Integer num){
        List<BookInfo> ranking = homeService.ranking(type,num);
        return ApiResponseObject.success(ranking);
    }

    @GetMapping("/lastUpdated")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value="书本类型",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "mode", value="最近更新/最近完结",dataType = "int",paramType = "query")
    })
    @ApiOperation(value = "最近更新")
    public ApiResponseObject<List<BookInfoAddNumDto>> lastUpdated(@RequestParam(defaultValue = "") String type, @RequestParam(defaultValue = "0") int mode){
        List<BookInfoAddNumDto> ranking = homeService.lastLpdateBook(type,mode);
        return ApiResponseObject.success(ranking);
    }

    @GetMapping("/announcement")
    @ApiOperation(value = "网站公告")
    public ApiResponseObject<List<Announcement>> announcement(){
        List<Announcement> announcement = homeService.getAnnouncement();
        return ApiResponseObject.success(announcement);
    }

}
