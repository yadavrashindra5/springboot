package com.practice.services;

import com.practice.dao.TodoDao;
import com.practice.model.Todo;
import com.practice.services.impl.DaoTodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoServiceImpl implements com.practice.services.impl.TodoService {

    @Autowired
    DaoTodoServiceImpl daoTodoService;
    public Todo createTodo(Todo todo){
        Todo todo1 = daoTodoService.createTodo(todo);
        return todo1;
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> allTodos = daoTodoService.getAllTodos();
        return allTodos;
    }

    @Override
    public Todo getTodo(int todoId) {
        Todo todo = daoTodoService.getTodo(todoId);
        return todo;
    }

    @Override
    public String deleteTodo(int todoId) {
        return daoTodoService.deleteTodo(todoId);
    }

    @Override
    public Todo updateTodo(Todo todo, int id) {
        Todo todo1 = daoTodoService.updateTodo(todo, id);
        return todo1;
    }


}
