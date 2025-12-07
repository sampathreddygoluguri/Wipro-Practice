package com.example.controller;

import com.example.dto.TaskDto;
import com.example.model.Task;
import com.example.model.User;
import com.example.service.TaskService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    // ============================================
    // DASHBOARD (Different for TL and SD users)
    // ============================================
    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard(Authentication auth) {
        String username = auth.getName();
        User u = userService.findByUsername(username);
        if (u == null) return ResponseEntity.status(404).body("User not found");

        // TEAMLEAD dashboard: show all tasks
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TL"))) {
            return ResponseEntity.ok(taskService.getAllTasks());
        }

        // NORMAL USER dashboard: show only assigned tasks
        return ResponseEntity.ok(taskService.getTasksForUser(u.getId()));
    }

    // ============================================
    // 1️⃣ CREATE TASK  (TeamLead only)
    // ============================================
    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody TaskDto dto, Authentication auth) {
        if (!auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TL"))) {
            return ResponseEntity.status(403).body("Only TeamLead can create tasks");
        }

        Task t = new Task();
        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setStatus(dto.getStatus() == null ? "OPEN" : dto.getStatus());

        Task created = taskService.createTask(t, dto.getAssigneeId());
        return ResponseEntity.ok(created);
    }

    // ============================================
    // 2️⃣ UPDATE EXISTING TASK (TeamLead only)
    // ============================================
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id,
                                        @RequestBody TaskDto dto,
                                        Authentication auth) {
        if (!auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TL"))) {
            return ResponseEntity.status(403).body("Only TeamLead can update tasks");
        }

        Task t = taskService.getTask(id);
        if (t == null) return ResponseEntity.notFound().build();

        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setStatus(dto.getStatus());

        Task updated = taskService.updateTask(id, t);
        return ResponseEntity.ok(updated);
    }

    // ============================================
    // 3️⃣ ALLOCATE TASK TO USER (TeamLead only)
    // ============================================
    @PutMapping("/allocate/{taskId}/{userId}")
    public ResponseEntity<?> allocateTask(@PathVariable Long taskId,
                                          @PathVariable Long userId,
                                          Authentication auth) {
        if (!auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TL"))) {
            return ResponseEntity.status(403).body("Only TeamLead can allocate tasks");
        }

        Task task = taskService.getTask(taskId);
        if (task == null) return ResponseEntity.status(404).body("Task not found");

        User user = userService.findById(userId);
        if (user == null) return ResponseEntity.status(404).body("User not found");

        task.setAssignee(user);
        Task updated = taskService.updateTask(taskId, task);

        return ResponseEntity.ok("Task allocated successfully to " + user.getUsername());
    }

    // ============================================
    // 4️⃣ DELETE TASK (TeamLead only)
    // ============================================
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id, Authentication auth) {
        if (!auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TL"))) {
            return ResponseEntity.status(403).body("Only TeamLead can delete tasks");
        }

        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }

    // ============================================
    // GET SINGLE TASK (Any authenticated user)
    // ============================================
    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        if (task == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(task);
    }
}