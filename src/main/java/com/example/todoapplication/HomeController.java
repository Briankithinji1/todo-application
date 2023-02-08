package com.example.todoapplication;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class HomeController {

    private final TodoItemService todoItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodo(@RequestBody TodoRequest todoRequest) {
        todoItemService.createTodo(todoRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResponse> getAllTodos() {
        return todoItemService.getAllTodos();
    }
    
}
