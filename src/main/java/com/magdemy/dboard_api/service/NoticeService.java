package com.magdemy.dboard_api.service;

import com.magdemy.dboard_api.model.Notice;
import com.magdemy.dboard_api.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    public Notice saveNotice(String imageData, String expiryDate) {
        Notice notice = new Notice();
        notice.setImageData(imageData);
        notice.setExpiryDate(expiryDate);
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllImages() {
        return noticeRepository.findAll();
    }

    public void deleteExpiredImages() {
        List<Notice> notices = noticeRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Notice image : notices) {
            LocalDate expiryDate = LocalDate.parse(image.getExpiryDate(), formatter);
            if (expiryDate.isBefore(currentDate)) {
                noticeRepository.deleteById(image.getId());
            }
        }
    }
}
