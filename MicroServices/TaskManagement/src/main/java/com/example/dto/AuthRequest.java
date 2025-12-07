package com.example.dto;

import lombok.*;


@Data
@NoArgsConstructor 
@AllArgsConstructor
public class AuthRequest {
  private String username;
  private String password;
  private String role; // optional for register
}

