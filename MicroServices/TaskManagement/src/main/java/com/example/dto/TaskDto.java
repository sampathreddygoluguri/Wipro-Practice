package com.example.dto;

import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class TaskDto {
  private String title;
  private String description;
  private String status;
  private Long assigneeId;
}