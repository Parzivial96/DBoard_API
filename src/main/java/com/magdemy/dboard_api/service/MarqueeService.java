package com.magdemy.dboard_api.service;

import com.magdemy.dboard_api.model.Marquee;
import com.magdemy.dboard_api.model.Todo;
import com.magdemy.dboard_api.repository.MarqueeRepository;
import com.magdemy.dboard_api.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MarqueeService {
    @Autowired
    private MarqueeRepository marqueeRepository;

    public List<Marquee> getAllMarquee(){
        return marqueeRepository.findAll();
    }

    public Marquee saveMarquee(String marqueeData, String expiryDate){
        Marquee marquee = new Marquee();
        marquee.setMarqueeData(marqueeData);
        marquee.setExpiryDate(expiryDate);
        return marqueeRepository.save(marquee);
    }

    public void deleteExpiredMarquees() {
        List<Marquee> marquees = marqueeRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Marquee marquee : marquees) {
            LocalDate expiryDate = LocalDate.parse(marquee.getExpiryDate(), formatter);
            if (expiryDate.isBefore(currentDate)) {
                marqueeRepository.deleteById(marquee.getId());
            }
        }
    }
}
