package com.ToDoList.DOit.Repository;


import com.ToDoList.DOit.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Sort tasks by priority
    @Query("SELECT t FROM Todo t ORDER BY t.priority DESC")
    List<Todo> findAllByOrderByPriorityDesc();
}