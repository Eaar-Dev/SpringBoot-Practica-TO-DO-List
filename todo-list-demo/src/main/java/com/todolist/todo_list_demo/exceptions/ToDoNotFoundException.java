package com.todolist.todo_list_demo.exceptions;

public class ToDoNotFoundException extends RuntimeException {

    public ToDoNotFoundException(Long id) {
        super("No se encontro ningúna taera con el id: " + id);
    }

}
