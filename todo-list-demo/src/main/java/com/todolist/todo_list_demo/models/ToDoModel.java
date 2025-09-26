package com.todolist.todo_list_demo.models;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor ponga un Titulo para esta tarea.")
    private String title;

    @NotBlank(message = "Por favor ponga una tarea por realizar.")
    private String task;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate taskDate;

}
