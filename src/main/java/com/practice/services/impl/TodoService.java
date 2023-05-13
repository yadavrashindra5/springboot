package com.practice.services.impl;

import com.practice.model.Todo;

import java.util.List;

public interface TodoService {
    public Todo createTodo(Todo todo);
    public List<Todo>getAllTodos();
    public Todo getTodo(int todoId);
    public String deleteTodo(int todoId);
    public Todo updateTodo(Todo todo,int id);
}
