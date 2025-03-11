package com.ToDoList.DOit.Entity;

import com.ToDoList.DOit.Priority;
import jakarta.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private boolean completed;
    @Enumerated(EnumType.STRING) // Store priority as a string in the database
    private Priority priority;

    // Constructors, Getters, and Setters
    public Todo() {}

    public Todo(String description, boolean completed, Priority priority) {
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}