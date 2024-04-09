package com.hana.comment;

import com.hana.app.data.dto.CommentDto;
import com.hana.app.service.CommentService;
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
    CommentService commentService;

    @Test
    void contextLoads() {
        CommentDto commentDto = CommentDto.builder().commentId(1).commentContent("강영현 바부 멍청이 말미잘").build();
        try {
            commentService.modify(commentDto);
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
