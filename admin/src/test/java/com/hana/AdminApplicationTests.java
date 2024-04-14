package com.hana;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootTest
@Slf4j
@EnableScheduling
class AdminApplicationTests {

    @Test
    void contextLoads() {
        log.info("OK------------------------");
    }

}
