package com.example.todoapplication;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoItemService {
    
    //@Autowired
    private final TodoItemRepository todoItemRepository;

    public void createTodo(TodoRequest todoRequest) {
        TodoItem todoItem = TodoItem.builder()
            .taskTitle(todoRequest.getTaskTitle())
            .description(todoRequest.getDescription())
            .build();

        todoItemRepository.save(todoItem);
        log.info("ToDo {} is saved", todoItem.getId());
    }

    public List<TodoResponse> getAllTodos() {
        List<TodoItem> todoItems = todoItemRepository.findAll();

        return todoItems.stream().map(this::mapToTodoResponse).toList();
    }

    private TodoResponse mapToTodoResponse(TodoItem todoItem) {
        return TodoResponse.builder()
                .id(todoItem.getId())
                .taskTitle(todoItem.getTaskTitle())
                .description(todoItem.getDescription())
                .build();
    }

}    