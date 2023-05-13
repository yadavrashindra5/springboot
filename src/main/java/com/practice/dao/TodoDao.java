package com.practice.dao;

import com.practice.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDao {
    private JdbcTemplate template;
    public TodoDao(@Autowired JdbcTemplate template){
        this.template=template;
        String createTable = "create table IF NOT EXISTS todos(id int primary key,title varchar(100)not null,content varchar(500),status varchar(10) not null, addedDate datetime,todoDate datetime)";
        int update = template.update(createTable);
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Todo saveTodo(Todo todo){
        String query="insert into todo(id,title,content) values(?,?,?)";
        int update = template.update(query,todo.getId(),todo.getTitle(),todo.getContent());
        return todo;
    }

    public List<Todo> getAllTodos(){
        String query="select * from todo";
        List<Todo> listTodos = template.query(query, new TodoRowMapper());
        return listTodos;
    }

    public Todo getTodo(int id){
        String query="select *from todo where id=?";
        Todo todo = template.queryForObject(query, new TodoRowMapper(), id);
        return todo;
    }

    public String deleteTodo(int id){
        String query="delete from todo where id=?";
        int result=template.update(query,id);
        return "delete Successfully";
    }

    public Todo updateTodo(Todo todo,int id){
        String query="update todo set title=?, content=? where id=?";
        int result=template.update(query,todo.getTitle(),todo.getContent(),id);
        todo.setId(id);
        return todo;
    }
}
