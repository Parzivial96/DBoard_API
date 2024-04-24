package com.magdemy.dboard_api.service;

import com.magdemy.dboard_api.model.Event;
import com.magdemy.dboard_api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }

    public Event saveEvent(String textData, String expiryDate){
        Event event = new Event();
        event.setTextData(textData);
        event.setExpiryDate(expiryDate);
        return eventRepository.save(event);
    }

    public void deleteEvent(String id){
        eventRepository.deleteById(id);
    }

    public void deleteExpiredEvents() {
        List<Event> events = eventRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Event event : events) {
            LocalDate expiryDate = LocalDate.parse(event.getExpiryDate(), formatter);
            if (expiryDate.isBefore(currentDate)) {
                eventRepository.deleteById(event.getId());
            }
        }
    }
}
