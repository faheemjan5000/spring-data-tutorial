package com.faheem.microservices.spring.data.tutorial;

import com.faheem.microservices.spring.data.tutorial.entity.Guardian;
import com.faheem.microservices.spring.data.tutorial.entity.Student;
import com.faheem.microservices.spring.data.tutorial.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentService studentService;

    @Autowired
    private WebApplicationContext applicationContext;

    @Test
    public void saveStudent(){
       Student student = Student.builder()
               .firstName("monica")
               .lastName("longo")
               .email("monica@gmail.com")
               .build();
       System.out.println("hello world");
        studentService.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = new Guardian("secondNana","SecondNana@gmail.com","7333882");
        Student student = new Student("faheem","secondFaheem","second@gmail.com",guardian);
        studentService.save(student);
    }

    @Test
    public void printAllStudents(){
        studentService.printAllStudents();
    }

    @Test
    public void getByStudentFirstName(){
        List<Student> students = studentService.findByFirstName("faheem");
        System.out.println(students);
        students.stream()
                .forEach(student-> Assert.assertEquals("faheem",student.getFirstName()));
    }

    @Test
    public void getByStudentFirstNameContaining(){
        List<Student> students = studentService.findByFirstName("fah");
        System.out.println(students);
        students.stream()
                .forEach(student-> Assert.assertTrue(student.getFirstName().contains("fah")));
    }

    @Test
    public void getStudentsByGuardianName(){
        List<Student> students = studentService.findByGuardianName("nana");
        System.out.println(students);
        students.stream()
                .forEach(student->Assert.assertTrue(student.getGuardian().getName().equalsIgnoreCase("nana")));
    }

}
