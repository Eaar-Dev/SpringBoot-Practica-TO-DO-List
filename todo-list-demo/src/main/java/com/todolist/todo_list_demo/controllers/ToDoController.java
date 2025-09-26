package com.todolist.todo_list_demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todo_list_demo.models.ToDoModel;
import com.todolist.todo_list_demo.repository.ToDoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/to-do")
public class ToDoController {

    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/firstGet")
    public String getTest() {
        return "Hola Mundo Desde SpringBoot!";
    }

    @GetMapping
    public List<ToDoModel> getAllToDo() {
        return toDoRepository.findAll();
    }

    @PostMapping
    public ToDoModel postNewToDo(@Valid @RequestBody ToDoModel toDoModel) {
        return toDoRepository.save(toDoModel);
    }

}
