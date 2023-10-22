package com.qingfeng.henthouse;

import com.qingfeng.henthouse.mapper.HomeBookMapper;
import com.qingfeng.henthouse.pojo.HomeBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HenthouseApplicationTests {

    @Autowired
    HomeBookMapper mapper;

    @Test
    void contextLoads() {
        String id[] = {
                "1431613237699391488",
                "1431626349915779072",
                "1431612847591370752",
                "1431625876961865728",
                "1431630568223780864",
                "1431630596354977792",
                "1431621906981826560",
                "1431615838276923392",
                "1431611431921496064",
                "1427173199813091328",
        };
        for (String s : id) {
            HomeBook homeBook = HomeBook.builder()
                    .type(2).sort(2)
                    .bookId(Long.valueOf(s)).createTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now()).build();
            mapper.insert(homeBook);
        }


    }

}
