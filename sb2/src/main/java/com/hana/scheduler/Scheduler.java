package com.hana.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class Scheduler {

    //           초  분  시  일 월 요일
    //    cron = "*  *  *  *  *  *"
    // 매일 일정시간에 해당 영역을 실행하게 할 수 있음
    @Scheduled(cron = "*/15 * * * * *")
    public void cronJobDailyUpdate() {
        log.info("-------------------------------------");
        log.info("사용자 로그인 정보를 조회하여 로그를 기록");
        log.info("-------------------------------------");
    }

    @Scheduled(cron = "1 0 0 1,8,15,22 * *")
    public void cronJobWeeklyUpdate(){

    }


}