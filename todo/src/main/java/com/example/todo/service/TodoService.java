package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    // Get All + Optional Filter
    public List<Todo> getAll(Boolean completed) {
        if (completed != null) {
            return repository.findByCompleted(completed);
        }
        return repository.findAll();
    }

    // Create
    public Todo create(Todo todo) {
        return repository.save(todo);
    }

    // Update title, description, completed
    public Todo update(Long id, Todo updated) {

        Todo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setCompleted(updated.isCompleted());

        return repository.save(existing);
    }

    // Delete
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
