package com.faheem.microservices.spring.data.tutorial.service;


import com.faheem.microservices.spring.data.tutorial.entity.StudentCourseMap;
import com.faheem.microservices.spring.data.tutorial.repository.StudentCourseMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseMapService {

    @Autowired
    StudentCourseMapRepository studentCourseMapRepository;

    public List<StudentCourseMap> getStudentCourseMapByStudentId(int id){
        return studentCourseMapRepository.findByStudentId(id);
    }
}
