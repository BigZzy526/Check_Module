package com.zzy;

import com.zzy.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
    @Autowired
    private CheckService checkService;
    // 每天零点触发
    @Scheduled(cron = "0 0 10 * * ?")
    public void resetDailyScoreAndStatus() {
        // 调用 service 将相应数据重置为默认值
        checkService.resetDailyScoreAndStatus();
    }

    @Scheduled(cron = "0 0 1 1 * ?")
    public void initializeData() {
        // 调用 service 将数据库中的数据初始化
        checkService.initializeData();
    }
}

