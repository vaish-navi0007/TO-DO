
package com.example.todo.repository;

import com.example.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // For filtering by completed status
    List<Todo> findByCompleted(boolean completed);
}
