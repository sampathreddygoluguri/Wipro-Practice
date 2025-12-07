package com.example.dto;

import lombok.*;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class AuthResponse {
  private String token;
}