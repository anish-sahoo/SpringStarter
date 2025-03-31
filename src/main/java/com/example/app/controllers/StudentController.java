package com.example.app.controllers;

import com.example.app.dto.StudentDTO;
import com.example.app.dto.StudentAddRequest;
import com.example.app.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

  private final StudentService service;
  private final Logger logger = LoggerFactory.getLogger(StudentController.class);

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public Optional<StudentDTO> getStudentById(@PathVariable Long id) {
    return service.getStudentById(id);
  }

  @GetMapping("/")
  public List<StudentDTO> getAllStudents() {
    return service.getAllStudents();
  }

  @PostMapping("/")
  public void addStudent(@RequestBody StudentAddRequest studentAddRequest) {
    service.addStudent(studentAddRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable Long id) {
    service.deleteStudent(id);
  }
}
