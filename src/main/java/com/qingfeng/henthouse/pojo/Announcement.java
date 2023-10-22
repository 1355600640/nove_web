package com.qingfeng.henthouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 网站公告
 * @TableName announcement
 */
@TableName(value ="announcement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 公告内容
     */
    private String body;

    /**
     * 是否跳转新的页面
     */
    private Integer isSkip;

    /**
     * 
     */
    private Date createTime;

}