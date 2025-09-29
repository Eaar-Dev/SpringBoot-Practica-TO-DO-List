package com.todolist.todo_list_demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todo_list_demo.exceptions.ToDoNotFoundException;
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
    public ResponseEntity<ToDoModel> postNewToDo(@Valid @RequestBody ToDoModel toDoModel) {
        ToDoModel newTask = toDoRepository.save(toDoModel);
        return ResponseEntity.created(URI.create("/api/to-do" + newTask.getId()))
                .body(newTask);
    }

    @GetMapping("/{id}")
    public ToDoModel getAllToDoTask(@PathVariable Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @PutMapping("/{id}")
    public ToDoModel putToDoUpdate(@PathVariable Long id, @Valid @RequestBody ToDoModel toDoModel) {

        return toDoRepository.findById(id).map(t -> {
            t.setTitle(toDoModel.getTitle());
            t.setTask(toDoModel.getTask());
            return toDoRepository.save(t);
        }).orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoById(@PathVariable Long id) {
        if (!toDoRepository.existsById(id)) {
            throw new ToDoNotFoundException(id);
        }
        toDoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
