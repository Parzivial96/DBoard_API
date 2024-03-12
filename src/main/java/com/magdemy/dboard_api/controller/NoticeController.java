package com.magdemy.dboard_api.controller;

import com.magdemy.dboard_api.model.Marquee;
import com.magdemy.dboard_api.model.Notice;
import com.magdemy.dboard_api.model.Todo;
import com.magdemy.dboard_api.service.MarqueeService;
import com.magdemy.dboard_api.service.NoticeService;
import com.magdemy.dboard_api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private TodoService todoService;

    @Autowired
    private MarqueeService marqueeService;

    @GetMapping("/getAllNotice")
    public List<Notice> getAllNotice(){
        return noticeService.getAllImages();
    }

    @PostMapping("/uploadNotice")
    public String uploadNotice(@RequestBody Notice notice){
        try {
            noticeService.saveNotice(notice.getImageData(),notice.getExpiryDate());
            return "Uploaded Successfully";
        }
        catch (Exception e){
            return "Upload Error";
        }
    }

    @PostMapping("/uploadTodo")
    public String uploadTodo(@RequestBody Todo todo){
        try {
            todoService.saveTodo(todo.getTextData(),todo.getExpiryDate());
            return "Uploaded Successfully";
        }
        catch (Exception e){
            return "Upload Error";
        }
    }

    @GetMapping("/getAllTodo")
    public List<Todo> getAllTodo(){
        return todoService.getAllTodo();
    }


    @PostMapping("/uploadMarquee")
    public String uploadMarquee(@RequestBody Marquee marquee){
        try {
            marqueeService.saveMarquee(marquee.getMarqueeData(),marquee.getExpiryDate());
            return "Uploaded Successfully";
        }
        catch (Exception e){
            return "Upload Error";
        }
    }

    @GetMapping("/getAllMarquee")
    public List<Marquee> getAllMarquee(){
        return marqueeService.getAllMarquee();
    }
}
