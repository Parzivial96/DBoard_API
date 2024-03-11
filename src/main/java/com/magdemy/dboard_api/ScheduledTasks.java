package com.magdemy.dboard_api;

import com.magdemy.dboard_api.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private NoticeService noticeService;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Run every 24 hours
    public void deleteExpiredImages() {
        noticeService.deleteExpiredImages();
    }
}
