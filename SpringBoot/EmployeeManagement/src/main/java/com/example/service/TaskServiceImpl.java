package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bean.Task;
import com.example.repo.TaskRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repo;

    @Override
    public Task createTask(Task task) {
        return repo.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        Optional<Task> existing = repo.findById(task.getId());
        if (existing.isEmpty()) return null;
        return repo.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        if (repo.existsById(id)) repo.deleteById(id);
    }

    @Override
    public Task getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Task> searchByStatus(String status) {
        return repo.findByStatusIgnoreCase(status);
    }

    @Override
    public List<Task> byPriority(String priority) {
        return repo.findByPriorityIgnoreCase(priority);
    }

    @Override
    public List<Task> overdueTasks() {
        return repo.findByDueDateBeforeAndStatusNot(LocalDate.now(), "completed");
    }
}
