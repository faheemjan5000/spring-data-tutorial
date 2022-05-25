package com.faheem.microservices.spring.data.tutorial.repository;

import com.faheem.microservices.spring.data.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

      List<Student> findByFirstName(String firstName);

      List<Student> findByFirstNameContaining(String pattern);

      //List<Student> findByLastNameNotNull(String lastName);

      List<Student> findByGuardianName(String guardianName);




}
