package com.faheem.microservices.spring.data.tutorial.service;

import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.entity.Teacher;
import com.faheem.microservices.spring.data.tutorial.exceptions.TeacherNotFoundException;
import com.faheem.microservices.spring.data.tutorial.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public List<Teacher> printAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherByTeacherId(int teacherId) throws TeacherNotFoundException {
       if(!teacherRepository.findById(teacherId).isPresent()){
           log.info("Teacher not exists!");
           throw new TeacherNotFoundException("Teacher not found");
       } else {
           log.info("Teacher found!!");
           return teacherRepository.findById(teacherId).get();
       }

    }
}
