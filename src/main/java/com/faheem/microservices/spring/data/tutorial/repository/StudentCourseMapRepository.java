package com.faheem.microservices.spring.data.tutorial.repository;

import com.faheem.microservices.spring.data.tutorial.entity.StudentCourseMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseMapRepository extends JpaRepository<StudentCourseMap,Integer> {

    public List<StudentCourseMap> findByCourseId(int id);

    public List<StudentCourseMap> findByStudentId(int id);
}
