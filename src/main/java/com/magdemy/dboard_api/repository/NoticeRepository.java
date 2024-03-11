package com.magdemy.dboard_api.repository;

import com.magdemy.dboard_api.model.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoticeRepository extends MongoRepository<Notice, String> {
}
