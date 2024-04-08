package com.hana.board;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.BoardService;
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
    BoardService boardService;

    @Test
    void contextLoads() {
        BoardDto boardDto = BoardDto.builder().boardId(1).boardTitle("데이식스 콘서트 합니다🍀").boardContent("많이 많이 와주세요 :)").build();
        try {
            boardService.modify(boardDto);
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
