package com.practice.controllers;

import com.practice.model.Todo;
import com.practice.services.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoServiceImpl todoService;
    Random random=new Random();
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
        todo.setId(random.nextInt(999999));
        Todo todo1=todoService.createTodo(todo);
        ResponseEntity<Todo>responseEntity=new ResponseEntity<>(todo1, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<List<Todo>>getAllTodoHandler(){
        List<Todo> allTodos = todoService.getAllTodos();
        ResponseEntity<List<Todo>>responseEntity=new ResponseEntity<>(allTodos,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo>getSingleTodoHandler(@PathVariable (value = "todoId") int todoId){
        Todo todo = todoService.getTodo(todoId);
        ResponseEntity<Todo>responseEntity=new ResponseEntity<>(todo,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<String>deleteTodo(@PathVariable(value = "todoId")int todoId){
        String s = todoService.deleteTodo(todoId);
        ResponseEntity<String>responseEntity=new ResponseEntity<>(s,HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo>updateTodoHandler(@RequestBody Todo todo,@PathVariable(value = "todoId") int todoId){
        Todo todo1 = todoService.updateTodo(todo, todoId);
        ResponseEntity<Todo>responseEntity=new ResponseEntity<>(todo1,HttpStatus.OK);
        return responseEntity;
    }
}
