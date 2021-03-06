package com.faheem.microservices.spring.data.tutorial.repository;

import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

   // List<Course> findByTeacherId(int teacherId);

    @Query(
            value = "SELECT * FROM course c WHERE c.teacher_id=?1",
            nativeQuery = true
    )
    List<Course> getCoursesByTeacherId(int teacherId);

}
