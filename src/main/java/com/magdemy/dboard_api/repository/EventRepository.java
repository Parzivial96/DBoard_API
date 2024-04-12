package com.magdemy.dboard_api.repository;

import com.magdemy.dboard_api.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event,String> {
}
