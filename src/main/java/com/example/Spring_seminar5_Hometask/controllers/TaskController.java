package com.example.Spring_seminar5_Hometask.controllers;

import com.example.Spring_seminar5_Hometask.model.Task;
import com.example.Spring_seminar5_Hometask.model.TaskStatus;
import com.example.Spring_seminar5_Hometask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления задачами.
 * Предоставляет API для создания, получения, обновления и удаления задач.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    /**
     * Репозиторий для работы с задачами
     */
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Создает новую задачу.
     *
     * @param task Данные задачи для создания.
     * @return Созданная задача с присвоенным ID и другими полями.
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    /**
     * Возвращает список всех задач.
     *
     * @return Список задач.
     */

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Возвращает задачи по указанному статусу.
     *
     * @param status Статус задачи для поиска.
     * @return Список задач с соответствующим статусом.
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    /**
     * Обновляет статус задачи по ее ID.
     *
     * @param id ID задачи для обновления.
     * @param taskDetails Обновленные данные задачи.
     * @return Обновленная задача.
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }

    /**
     * Удаляет задачу по ее ID.
     *
     * @param id ID задачи для удаления.
     */

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
