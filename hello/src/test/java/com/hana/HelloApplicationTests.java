package com.hana;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// lombok 에서 제공해주는 로그를 찍어주는 라이브러리
@Slf4j
class HelloApplicationTests {

    // start point
    @Test
    void contextLoads() {
        log.info("Log Test");
    }

}
