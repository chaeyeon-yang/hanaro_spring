package com.hana.cust;

import com.hana.app.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DeleteTests {

    @Autowired
    AdminService adminService;

    @Test
    void contextLoads() {
        try {
            adminService.del("madmin");
            log.info("OK------------------------");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
