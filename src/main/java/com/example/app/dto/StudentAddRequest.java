package com.example.app.dto;

import lombok.Data;

@Data
public class StudentAddRequest {
  private String name;
  private int age;
  private String grade;
  private String email;
}
