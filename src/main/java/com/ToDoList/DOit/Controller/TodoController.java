package com.ToDoList.DOit.Controller;


import com.ToDoList.DOit.Entity.Todo;
import com.ToDoList.DOit.Priority;
import com.ToDoList.DOit.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String getAllTodos(@RequestParam(required = false) String sort, Model model) {
        if ("priority".equals(sort)) {
            model.addAttribute("todos", todoService.getAllTodosSortedByPriority());
        } else {
            model.addAttribute("todos", todoService.getAllTodos());
        }
        return "index";
    }

    // Add a new to-do item with priority
    @PostMapping("/add")
    public String addTodo(@RequestParam String description, @RequestParam Priority priority) {
        Todo todo = new Todo(description, false);
        todoService.saveTodo(todo);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTodoCompletion(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        if (todo != null) {
            todo.setCompleted(!todo.isCompleted());
            todoService.saveTodo(todo);
        }
        return "redirect:/";
    }
}