package com.practice.services.impl;

import com.practice.dao.TodoDao;
import com.practice.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DaoTodoServiceImpl implements TodoService{
    @Autowired
    TodoDao todoDao;
    @Override
    public Todo createTodo(Todo todo) {
        Todo todo1 = todoDao.saveTodo(todo);
        return todo1;
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> allTodos = todoDao.getAllTodos();
        return allTodos;
    }

    @Override
    public Todo getTodo(int todoId) {
        Todo todo = todoDao.getTodo(todoId);
        return todo;
    }

    @Override
    public String deleteTodo(int todoId) {
        String s = todoDao.deleteTodo(todoId);
        return s;
    }

    @Override
    public Todo updateTodo(Todo todo, int id) {
        Todo todo1 = todoDao.updateTodo(todo, id);
        return todo1;
    }
}
