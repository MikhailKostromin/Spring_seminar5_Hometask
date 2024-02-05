package com.example.Spring_seminar5_Hometask.repository;

import com.example.Spring_seminar5_Hometask.model.Task;
import com.example.Spring_seminar5_Hometask.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  Интерфейс репозитория для сущности задачи (Task).
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
