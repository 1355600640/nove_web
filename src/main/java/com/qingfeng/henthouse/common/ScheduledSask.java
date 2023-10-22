package com.qingfeng.henthouse.common;

import com.qingfeng.henthouse.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@EnableScheduling
@Component
public class ScheduledSask {

    @Autowired
    private HomeService homeService;
//    本周热门每周一自动刷新 热门推荐
//    @Scheduled(cron ="0 0 1 * * 1 *" )
//    public void renewalWeekRecommended(){
//        homeService.recommend()
//    }
}
