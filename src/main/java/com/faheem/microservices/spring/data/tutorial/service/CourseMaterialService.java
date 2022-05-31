package com.faheem.microservices.spring.data.tutorial.service;

import com.faheem.microservices.spring.data.tutorial.entity.CourseMaterial;
import com.faheem.microservices.spring.data.tutorial.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial){
        return courseMaterialRepository.save(courseMaterial);
    }

    public List<CourseMaterial> getAllCourseMaterials(){
        return courseMaterialRepository.findAll();
    }
}
