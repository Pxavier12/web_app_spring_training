package fr.lernejo.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {

    private final TodoService todoService;

    private TodoRepository todoRepository;

    public TodoListController(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public Iterable<TodoEntity> getTodos(){
        return todoRepository.findAll();
    }

    @PostMapping
    public TodoEntity addTodo(@RequestBody TodoEntity todo){
        return todoRepository.save(todo);

    };
}
