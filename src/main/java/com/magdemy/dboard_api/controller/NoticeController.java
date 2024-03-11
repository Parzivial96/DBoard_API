package com.magdemy.dboard_api.controller;

import com.magdemy.dboard_api.model.Notice;
import com.magdemy.dboard_api.service.NoticeService;
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
}
