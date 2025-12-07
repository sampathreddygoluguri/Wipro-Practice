package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bean.Task;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByStatusIgnoreCase(String status);
    List<Task> findByPriorityIgnoreCase(String priority);
    List<Task> findByDueDateBeforeAndStatusNot(LocalDate date, String status);
}
