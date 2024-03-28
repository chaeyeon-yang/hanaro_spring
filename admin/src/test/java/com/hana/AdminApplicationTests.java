package com.hana;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j // 언제 어디서나 log 를 찍을 수 있도록 함
class AdminApplicationTests {

    @Test
    void contextLoads() {
        log.info("OK-----------------------");
    }

}
