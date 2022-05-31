package com.faheem.microservices.spring.data.tutorial.service;


import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.entity.Student;
import com.faheem.microservices.spring.data.tutorial.exceptions.NoStudentAvailableException;
import com.faheem.microservices.spring.data.tutorial.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student){
        log.info("StudentService.save() called...");
        log.info("student added : {} ",student);
       return studentRepository.save(student);
    }

    public void printAllStudents() throws NoStudentAvailableException {
        log.info("StudentService.printAllStudents() called....");
        List<Student> students = studentRepository.findAll();
        if(students!=null){
            log.info("students exist!!");
            log.info("students found are : {} ",students);
        }
        else{
            log.info("students not found!");
            throw new NoStudentAvailableException("there is currently no  student in database..");
        }
    }

    public List<Student> findByFirstName(String firstName){
        log.info("StudentService.");
       return studentRepository.findByFirstName(firstName);
    }


    public List<Student> findByGuardianName(String guardianName){
        return studentRepository.findByGuardianName(guardianName);
    }

    public  Student findByFirstNameAndLastName(String firstName , String lastName){

        return studentRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    public  Student getStudentByEmailAddress(String emailAddress){
        return studentRepository.getStudentByEmailAddress(emailAddress);
    }

    public String getStudentFirstNameByEmailAddress(String emailAddress){
        return studentRepository.getStudentFirstNameByEmailAddress(emailAddress);
    }

    public Student getStudentByEmailAddressNativeQueryExample(String emailAddress){
        return studentRepository.getStudentByEmailAddressNativeQueryExample(emailAddress);
    }

    public  void updateFirstNameByEmailId(String firstName, String email){
        studentRepository.updateFirstNameByEmailId(firstName,email);
    }




}
