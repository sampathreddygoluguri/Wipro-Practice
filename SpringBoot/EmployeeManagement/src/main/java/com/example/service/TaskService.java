package com.example.service;

import com.example.bean.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Integer id);
    Task getById(Integer id);
    List<Task> getAll();
    List<Task> searchByStatus(String status);
    List<Task> byPriority(String priority);
    List<Task> overdueTasks();
}
