package org.telran.validationExample.com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleServiceImpl {

    private static final Logger log = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    //@Scheduled(fixedRate = 10000)
    //@Scheduled(fixedDelay = 5000, initialDelay = 3000)
    @Scheduled(cron = "0 * 9 * * ?")
    @Scheduled(cron = "@hourly")
    public void cronJob() {
        log.debug("It is scheduler job {}", new Date());
    }
}
