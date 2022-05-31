package com.faheem.microservices.spring.data.tutorial.repository;

import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

    /*

    @Query(
            value = "SELECT * FROM teacher s WHERE s.teacher_id=?1 ", //error in SELECT(select only courses)
            nativeQuery = true
    )
    List<Course> getAllCoursesByTeacherId(int teacherId);


     */

}
