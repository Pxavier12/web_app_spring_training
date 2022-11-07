package fr.lernejo.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {


    public List<Todo>todos = new ArrayList<>();
    public List<Todo> getTodos(){
        return todos;
    }

    public void addTodos(Todo todo){
        todos.add(new Todo(todo.message(),todo.author()));
    }
}
