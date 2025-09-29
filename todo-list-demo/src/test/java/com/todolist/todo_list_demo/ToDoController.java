package com.todolist.todo_list_demo;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCrearYListarToDo() throws Exception {
        String nuevoToDo = """
                    {
                        "title": "¿Ya arreglé mi memoria de la cabeza?",
                        "task": "¿Ya no se me olvidan las cosas?"
                    }
                """;
        mockMvc.perform(post("/api/to-do")
        .contentType(MediaType.APPLICATION_JSON)
        .content(nuevoToDo))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.title", is("¿Ya arreglé mi memoria de la cabeza?")));

        mockMvc.perform(get("/api/to-do"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)));
    }
}
