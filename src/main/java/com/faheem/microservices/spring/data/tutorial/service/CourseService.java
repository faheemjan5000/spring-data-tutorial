package com.faheem.microservices.spring.data.tutorial.service;

import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course){
        log.info("CourseService.saveCourse() method called.....");
        return courseRepository.save(course);
    }

    public List<Course> printAllcourses(){
        return courseRepository.findAll();
    }

    public List<Course> getCoursesByTeacherId(int teacherId){
        return courseRepository.getCoursesByTeacherId(teacherId);
    }

}
