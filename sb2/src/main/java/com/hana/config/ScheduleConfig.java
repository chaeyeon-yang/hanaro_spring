package com.hana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ScheduleConfig implements SchedulingConfigurer

{
    // 스레드 6개가 동시다발적으로 동작할 수 있는
    private final int POOL_SIZE = 6;

    @Override
    public void configureTasks(ScheduledTaskRegistrar registry) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

        threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix("CommB-Scheduled-task-");
        threadPoolTaskScheduler.initialize();

        registry.setTaskScheduler(threadPoolTaskScheduler);
    }

}