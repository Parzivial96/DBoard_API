package com.magdemy.dboard_api;

import com.magdemy.dboard_api.service.EventService;
import com.magdemy.dboard_api.service.MarqueeService;
import com.magdemy.dboard_api.service.NoticeService;
import com.magdemy.dboard_api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private TodoService todoService;

    @Autowired
    private MarqueeService marqueeService;

    @Autowired
    private EventService eventService;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Run every 24 hours
    public void deleteExpiredImages() {
        noticeService.deleteExpiredImages();
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Run every 24 hours
    public void deleteExpiredTodos() {
        todoService.deleteExpiredTodos();
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Run every 24 hours
    public void deleteExpiredMarquee() {
        marqueeService.deleteExpiredMarquees();
    }

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Run every 24 hours
    public void deleteExpiredEvent() {
        eventService.deleteExpiredEvents();
    }
}
