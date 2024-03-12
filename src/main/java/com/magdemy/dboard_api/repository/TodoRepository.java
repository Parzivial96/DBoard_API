package com.magdemy.dboard_api.repository;

import com.magdemy.dboard_api.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
