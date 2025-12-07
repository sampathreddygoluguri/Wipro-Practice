package com.example.service;

import com.example.model.Task;
import com.example.model.User;
import com.example.repository.TaskRepository;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
  private final TaskRepository taskRepo;
  private final UserRepository userRepo;

  public Task createTask(Task t, Long assigneeId) {
    if (assigneeId != null) {
      userRepo.findById(assigneeId).ifPresent(t::setAssignee);
    }
    return taskRepo.save(t);
  }

  public Task updateTask(Long id, Task data) {
    return taskRepo.findById(id).map(task -> {
      task.setTitle(data.getTitle());
      task.setDescription(data.getDescription());
      task.setStatus(data.getStatus());
      if (data.getAssignee() != null) task.setAssignee(data.getAssignee());
      return taskRepo.save(task);
    }).orElseThrow(() -> new RuntimeException("Task not found"));
  }

  public void deleteTask(Long id) { taskRepo.deleteById(id); }
  public Task getTask(Long id) { return taskRepo.findById(id).orElse(null); }
  public List<Task> getAllTasks() { return taskRepo.findAll(); }
  public List<Task> getTasksForUser(Long userId) { return taskRepo.findByAssigneeId(userId); }
}