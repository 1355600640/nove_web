package com.qingfeng.henthouse.Dto;

import com.qingfeng.henthouse.pojo.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfoAddNumDto extends BookInfo implements Serializable {
    private long num;
    private static final long serialVersionUID = 1L;
}
