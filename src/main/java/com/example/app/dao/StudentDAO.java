package com.example.app.dao;

import com.example.app.dto.StudentDTO;
import com.example.app.repository.StudentRepository;
import com.example.app.repository.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentDAO {

  private final StudentRepository repository;

  @Autowired
  public StudentDAO(StudentRepository repository) {
    this.repository = repository;
  }

  public Optional<StudentDTO> findById(Long id) {
    return repository.findByIdSQL(id)
        .map(entity -> new StudentDTO(entity.getId(), entity.getName(), entity.getAge(), entity.getGrade(), entity.getEmail()));
  }

  public List<StudentDTO> findAll() {
    return repository.findAllSQL()
        .stream()
        .map(entity -> new StudentDTO(entity.getId(), entity.getName(), entity.getAge(), entity.getGrade(), entity.getEmail()))
        .collect(Collectors.toList());
  }

  public void deleteById(Long id) {
    repository.deleteByIdSQL(id);
  }

  public void addStudent(String name, int age, String grade, String email) {
    repository.addStudent(name, age, grade, email);
  }
}
