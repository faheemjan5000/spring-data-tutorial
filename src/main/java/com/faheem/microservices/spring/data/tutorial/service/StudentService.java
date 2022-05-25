package com.faheem.microservices.spring.data.tutorial.service;


import com.faheem.microservices.spring.data.tutorial.entity.Student;
import com.faheem.microservices.spring.data.tutorial.repository.StudentRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void save(Student student){
        studentRepository.save(student);
    }

    public void printAllStudents(){
        System.out.println(studentRepository.findAll());
    }

    public List<Student> findByFirstName(String firstName){
       return studentRepository.findByFirstName(firstName);
    }

    public List<Student> findByFirstNameContainint(String pattern){
        return studentRepository.findByFirstNameContaining(pattern);
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

}
