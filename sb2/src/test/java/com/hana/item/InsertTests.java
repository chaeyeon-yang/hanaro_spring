package com.hana.item;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.CustService;
import com.hana.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;
import java.time.LocalDate;

@SpringBootTest
@Slf4j
class InsertTests {

    @Autowired
    ItemService itemService;
    @Test
    void contextLoads() {
        ItemDto itemDto = ItemDto.builder().itemName("영현이 신발").itemPrice(200000L).imgName("영현이의 멋진 신발 사진.jpg").build();
        try {
            itemService.add(itemDto);
            log.info("----------OK----------------");
        } catch (Exception e) {
            if(e instanceof SQLException){
                log.info("----------System Trouble EX0001----------------");
            }else if(e instanceof DuplicateKeyException){
                log.info("----------ID Duplicated EX0002----------------");
            }else{
                e.printStackTrace();
                log.info("----------Sorry EX0003----------------");
            }
        }
    }

}
