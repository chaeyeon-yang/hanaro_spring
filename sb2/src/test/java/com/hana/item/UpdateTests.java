package com.hana.item;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class UpdateTests {

    @Autowired
    ItemService itemService;
    @Test
    void contextLoads() {
        ItemDto itemDto = ItemDto.builder().itemId(1).itemName("도운이 모자").itemPrice(300000L).imgName("윤도운 모자 사진.jpg").build();
        try {
            itemService.modify(itemDto);
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
