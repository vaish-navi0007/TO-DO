package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    // Create Todo
    @PostMapping
    public Todo create(@Valid @RequestBody Todo todo) {
        return service.create(todo);
    }

    // Get All Todos + Optional Filter
    @GetMapping
    public List<Todo> getAll(@RequestParam(required = false) Boolean completed) {
        return service.getAll(completed);
    }

    // Update Todo
    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.update(id, todo);
    }

    // Delete Todo
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
