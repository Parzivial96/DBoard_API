package com.magdemy.dboard_api.controller;

import com.magdemy.dboard_api.model.Event;
import com.magdemy.dboard_api.model.Marquee;
import com.magdemy.dboard_api.model.Notice;
import com.magdemy.dboard_api.model.Todo;
import com.magdemy.dboard_api.service.EventService;
import com.magdemy.dboard_api.service.MarqueeService;
import com.magdemy.dboard_api.service.NoticeService;
import com.magdemy.dboard_api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private EventService eventService;


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


    @PostMapping("/uploadEvent")
    public String uploadEvent(@RequestBody Event event){
        try {
            eventService.saveEvent(event.getTextData(),event.getExpiryDate());
            return "Uploaded Successfully";
        }
        catch (Exception e){
            return "Upload Error";
        }
    }

    @GetMapping("/getAllEvent")
    public List<Event> getAllEvent(){
        return eventService.getAllEvent();
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

    @PostMapping("/deleteMarquee")
    public void deleteMarquee(@RequestBody Map<String, String> request){
        String id = request.get("id");
        marqueeService.deleteMarquee(id);
    }

    @PostMapping("/deleteTodo")
    public void deleteTodo(@RequestBody Map<String, String> request){
        String id = request.get("id");
        todoService.deleteTodo(id);
    }

    @PostMapping("/deleteNotice")
    public void deleteNotice(@RequestBody Map<String, String> request){
        String id = request.get("id");
        noticeService.deleteNotice(id);
    }

    @PostMapping("/deleteEvent")
    public void deleteEvent(@RequestBody Map<String, String> request){
        String id = request.get("id");
        eventService.deleteEvent(id);
    }
}
