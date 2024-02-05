package com.example.Spring_seminar5_Hometask.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * Сущность задачи.
 */
@Data
@Entity
@Table(name = "task_table")
public class Task {

    /**
     * Уникальный идентификатор задачи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Описание задачи.
     */
    private String description;

    /**
     * Статус задачи.
     */
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /**
     * Время выполнения задачи.
     */
    @Column(name = "lead_time")
    private LocalDateTime leadTime;

}
