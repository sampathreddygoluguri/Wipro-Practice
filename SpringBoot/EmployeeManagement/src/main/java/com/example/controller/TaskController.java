package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bean.Task;
import com.example.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task) 
    {
        try {
            Task saved = taskService.createTask(task);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/get")
    public ResponseEntity<List<Task>> getAllTasks()
    {
        List<Task> tasks = taskService.getAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id)
    {
        Task task = taskService.getById(id);
        if (task == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task)
    {
        if (task.getId() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Task updated = taskService.updateTask(task);
        if (updated == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer id)
    {
        Task task = taskService.getById(id);

        if (task == null)
            return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);

        taskService.deleteTask(id);
        return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/search/{status}")
    public ResponseEntity<List<Task>> searchByStatus(@PathVariable String status)
    {
        List<Task> result = taskService.searchByStatus(status);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getByPriority(@PathVariable String priority)
    {
        List<Task> result = taskService.byPriority(priority);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Task>> getOverdueTasks()
    {
        List<Task> result = taskService.overdueTasks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
