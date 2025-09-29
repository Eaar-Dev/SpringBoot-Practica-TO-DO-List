# 📚 API REST – Gestor de Tareas con Spring Boot

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3-green?logo=spring)
![Build](https://img.shields.io/badge/Build-Maven-orange?logo=apache-maven)
![Tests](https://img.shields.io/badge/Tests-JUnit5-yellow?logo=testing-library)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Este proyecto es una **API REST** construida con **Spring Boot**, que permite gestionar tareas de la vida cotidiana.
Incluye operaciones CRUD, validación de datos, pruebas unitarias con JUnit + MockMvc y documentación con Swagger.

---

## 🚀 Tecnologías utilizadas

- ☕ **Java 17+**
- 🍃 **Spring Boot 3+**
- 🌐 **Spring Web**
- 💾 **Spring Data JPA + H2 Database (en memoria)**
- 🔧 **Lombok**
- 🧪 **JUnit 5 + MockMvc**
- 📖 **Swagger OpenAPI**

---

## ⚙️ Instalación y ejecución

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/springboot-libros.git
   cd springboot-libros
   ```

2. Compilar y ejecutar con Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

3. La API estará disponible en:

   ```
   http://localhost:8080/api/to-do
   ```

4. Documentación Swagger UI:

   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 📌 Endpoints principales

| Método   | Endpoint          | Descripción             |
| -------- | ----------------- | ----------------------- |
| `POST`   | `/api/to-do`      | Crear una tarea         |
| `GET`    | `/api/to-do`      | Listar todas las tareas |
| `GET`    | `/api/to-do/{id}` | Obtener tareas por ID   |
| `PUT`    | `/api/to-do/{id}` | Actualizar tarea        |
| `DELETE` | `/api/to-do/{id}` | Eliminar tarea          |

## Próximamente nuevas implementaciones

## 📖 Ejemplo de uso

**Crear una tarea o pendiente**

```http
POST /api/to-do
Content-Type: application/json
```

**Body**

```json
{
  "title": "Seguir Aprendiendo Java/SpringBoot",
  "task": "Conceptos, Sintaxis y Práctica"
}
```

**Response (201 Created)**

```json
{
  "id": 1,
  "title": "Seguir Aprendiendo Java/SpringBoot",
  "task": "Conceptos, Sintaxis y Práctica",
  "taskDate": "26-09-2025"
}
```

---

## 🧪 Pruebas

Ejecutar pruebas unitarias:

```bash
./mvnw test
```

Ejemplo de test:

```java
mockMvc.perform(post("/api/to-do")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"title\":\"Seguir Aprendiendo Java/SpringBoot\", \"task\":\"Conceptos, Sintaxis y Práctica\"}"))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.titulo").value("Seguir Aprendiendo Java/SpringBoot"));
---

## 📜 Licencia

Este proyecto se distribuye bajo la licencia MIT.
Puedes usarlo y modificarlo libremente.
```
