package com.faheem.microservices.spring.data.tutorial;


import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.entity.Teacher;
import com.faheem.microservices.spring.data.tutorial.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void printCourses(){
        List<Course> courses = courseService.printAllcourses();
        System.out.println("Courses : "+courses);
    }

    @Test
    public void getCoursesByTeacherId(){
        int teacherId = 3;
        List<Course> courses = courseService.getCoursesByTeacherId(teacherId);
        if(courses!=null){
            log.info("courses found!!");
            log.info("Courses are : {}",courses);
        }
        else{
            log.info("No course Found for this teacher!");
        }

    }
    @Test
    public void saveCourseWithTeacher(){
        log.info("CourseRepositoryTest.saveCourseWithTeacher() method called....");
        Teacher teacher = Teacher.builder()
                .firstName("lorenzo")
                .lastName("bosaka")
                .build();
        Course courseMechanical = Course.builder()
                .title("mechanical")
                .credit(10)
                .teacher(teacher)
                .build();
       Course courseSaved = courseService.saveCourse(courseMechanical);
       log.info("course saved is : {}",courseSaved);
    }

}
