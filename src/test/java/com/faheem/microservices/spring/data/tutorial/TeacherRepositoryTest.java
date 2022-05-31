package com.faheem.microservices.spring.data.tutorial;


import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.entity.Teacher;
import com.faheem.microservices.spring.data.tutorial.exceptions.TeacherNotFoundException;
import com.faheem.microservices.spring.data.tutorial.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    public TeacherService teacherService;

    /*
    @Test
    public void saveTeacher(){
        Course courseJava = Course.builder()
                .title("HTML")
                .credit(10)
                .build();
        Course courseChemistry = Course.builder()
                .title("CPP")
                .credit(12)
                .build();
        List<Course> courses = new ArrayList<>();
        courses.add(courseJava);
        courses.add(courseChemistry);
        Teacher teacher = Teacher.builder()
                .firstName("Alexa")
                .lastName("monica")
                .courses(courses)
                .build();
        teacherService.saveTeacher(teacher);
    }

     */


    @Test
    public void printAllTeachers(){
        List<Teacher> teachers = teacherService.printAllTeachers();
        System.out.println(teachers);
    }

    @Test
    public void getTeacherByTeacherId() throws TeacherNotFoundException {
        int teacherId = 3;
        Teacher teacher = teacherService.getTeacherByTeacherId(teacherId);
        log.info("Teacher : {}" , teacher);
        Assert.assertTrue(teacher.getTeacherId()==teacherId);
    }
}
