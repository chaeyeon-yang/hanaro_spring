package com.hana.cust;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.AdminService;
import com.hana.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UpdateTests {

    @Autowired
    CustService custService;

    @Test
    void contextLoads() {
        CustDto custDto = CustDto.builder().id("id77").pwd("pwd77").name("서희정").build();

        try {
            custService.modify(custDto);
            log.info("OK------------------------");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
