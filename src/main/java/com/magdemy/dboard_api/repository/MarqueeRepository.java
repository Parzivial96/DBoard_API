package com.magdemy.dboard_api.repository;

import com.magdemy.dboard_api.model.Marquee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarqueeRepository extends MongoRepository<Marquee, String> {
}
