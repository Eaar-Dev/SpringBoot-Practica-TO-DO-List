package com.todolist.todo_list_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todo_list_demo.models.ToDoModel;

public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {

}
