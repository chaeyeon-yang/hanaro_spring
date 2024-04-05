package com.hana.cust;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class InsertTests {

    @Autowired
    CustService custService;

    @Test
    void contextLoads() {
        CustDto custDto = CustDto.builder().id("레모니").pwd("lelemon").name("레모니").build();

        try {
            custService.add(custDto);
            log.info("OK------------------------");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
