package com.faheem.microservices.spring.data.tutorial;

import com.faheem.microservices.spring.data.tutorial.entity.Guardian;
import com.faheem.microservices.spring.data.tutorial.entity.Student;
import com.faheem.microservices.spring.data.tutorial.exceptions.NoStudentAvailableException;
import com.faheem.microservices.spring.data.tutorial.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
@Slf4j
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
               .email("monica2@gmail.com")
               .build();
       System.out.println("hello world");
        studentService.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = new Guardian("thirdNana","third@gmail.com","7333882");
        Student student = new Student("faheem","thirdFaheem","third@gmail.com",guardian);
        studentService.save(student);
    }

    @Test
    public void printAllStudents() throws NoStudentAvailableException {
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

    @Test
     public void getByFirstNameAndLastName(){
        String firstName ="faheem";
        String lastName = "jan";
        Student studentFound = studentService.findByFirstNameAndLastName(firstName,lastName);
       Assert.assertEquals("faheem",studentFound.getFirstName());
       Assert.assertEquals("jan",studentFound.getLastName());
       log.info("student found is :{}", studentFound);

    }

    @Test
    public  void getStudentByEmailAddress(){
        String emailAddress = "harnnoon@gmail.com";
        Student student = studentService.getStudentByEmailAddress(emailAddress);
        log.info("student is : {}",student);
        Assert.assertTrue(student.getEmail().equalsIgnoreCase(emailAddress));
    }

    @Test
    public  void getStudentFirstNameByEmailAddress(){
        String emailAddress = "harnnoon@gmail.com";
        String studentFirstName = studentService.getStudentFirstNameByEmailAddress(emailAddress);
        log.info("student firstName is : {}",studentFirstName);
        Assert.assertTrue(studentFirstName.equalsIgnoreCase("haroon"));
    }

    @Test
    public  void getStudentByEmailAddressNativeQueryExample(){
        String emailAddress = "harnnoon@gmail.com";
        Student student = studentService.getStudentByEmailAddressNativeQueryExample(emailAddress);
        log.info("student : {}",student);
        Assert.assertTrue(student.getEmail().equalsIgnoreCase(emailAddress));
    }

    @Test
    public  void getStudentByEmailAddressNativeQueryPARAMExample(){
        String emailAddress = "harnnoon@gmail.com";
        Student student = studentService.getStudentByEmailAddressNativeQueryExample(emailAddress);
        log.info("student : {}",student);
        Assert.assertTrue(student.getEmail().equalsIgnoreCase(emailAddress));
    }

    @Test
    public void updateFirstNameByEmailId(){
        String firstName = "fahaam";
        String email = "third@gmail.com";
        studentService.updateFirstNameByEmailId(firstName,email);
        Student student = studentService.getStudentByEmailAddress(email);
        log.info("student : {}",student);
        Assert.assertTrue(student.getFirstName().equalsIgnoreCase(firstName));
    }


}
