package com.hana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
// spring의 스케쥴링 기능 활성화
// 스케줄링을 사용하면 특정 시간 간격으로 자동으로 메소드를 실행할 수 있다. 예를 들어, 주기적으로 데이터베이스를 업데이트하거나, 정기적인 작업을 실행하는 데 사용할 수 있다
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
