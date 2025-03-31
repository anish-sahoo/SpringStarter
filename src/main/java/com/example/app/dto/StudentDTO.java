package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
  private Long id;
  private String name;
  private int age;
  private String grade;
  private String email;
}
