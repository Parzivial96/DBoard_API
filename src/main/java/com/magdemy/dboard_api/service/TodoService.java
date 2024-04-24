package com.magdemy.dboard_api.service;

import com.magdemy.dboard_api.model.Todo;
import com.magdemy.dboard_api.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodo(){
        return todoRepository.findAll();
    }

    public Todo saveTodo(String textData, String expiryDate){
        Todo todo = new Todo();
        todo.setTextData(textData);
        todo.setExpiryDate(expiryDate);
        return todoRepository.save(todo);
    }

    public void deleteTodo(String id){
        todoRepository.deleteById(id);
    }

    public void deleteExpiredTodos() {
        List<Todo> todos = todoRepository.findAll();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Todo todo : todos) {
            LocalDate expiryDate = LocalDate.parse(todo.getExpiryDate(), formatter);
            if (expiryDate.isBefore(currentDate)) {
                todoRepository.deleteById(todo.getId());
            }
        }
    }
}
