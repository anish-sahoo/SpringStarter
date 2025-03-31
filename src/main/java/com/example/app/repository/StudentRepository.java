package com.example.app.repository;

import com.example.app.repository.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query(value = "SELECT * FROM students WHERE id = :id", nativeQuery = true)
  Optional<Student> findByIdSQL(@Param("id") Long id);

  @Query(value = "SELECT * FROM students", nativeQuery = true)
  List<Student> findAllSQL();

  @Modifying
  @Query(value = "DELETE FROM students WHERE id = :id", nativeQuery = true)
  void deleteByIdSQL(@Param("id") Long id);

  @Modifying
  @Query(value = "INSERT INTO students (name, age, grade, email) VALUES (:name, :age, :grade, :email)", nativeQuery = true)
  void addStudent(@Param("name") String name, @Param("age") int age, @Param("grade") String grade, @Param("email") String email);
}
