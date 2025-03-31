package com.example.app.service;

import com.example.app.dao.StudentDAO;
import com.example.app.dto.StudentAddRequest;
import com.example.app.dto.StudentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private final StudentDAO studentDAO;

  @Autowired
  public StudentService(StudentDAO studentDAO) {
    this.studentDAO = studentDAO;
  }

  public Optional<StudentDTO> getStudentById(Long id) {
    return studentDAO.findById(id);
  }

  public List<StudentDTO> getAllStudents() {
    return studentDAO.findAll();
  }

  public void deleteStudent(Long id) {
    studentDAO.deleteById(id);
  }

  public void addStudent(StudentAddRequest studentAddRequest) {
    studentDAO.addStudent(studentAddRequest.getName(), studentAddRequest.getAge(), studentAddRequest.getGrade(), studentAddRequest.getEmail());
  }
}
