package com.faheem.microservices.spring.data.tutorial;

import com.faheem.microservices.spring.data.tutorial.entity.Course;
import com.faheem.microservices.spring.data.tutorial.entity.CourseMaterial;
import com.faheem.microservices.spring.data.tutorial.service.CourseMaterialService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialService courseMaterialService;

    @Autowired
    private WebApplicationContext applicationContext;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .credit(10)
                .title("physics")
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseMaterialUrl("www.physics.com")
                .course(course)
                .build();
        CourseMaterial courseMaterial1FromDatabase =courseMaterialService.saveCourseMaterial(courseMaterial);
        Assert.assertTrue(courseMaterial1FromDatabase.getCourse().getCredit()==10);
    }

    @Test
    public void getAllCourseMaterials(){
        List<CourseMaterial> allCourseMaterials = courseMaterialService.getAllCourseMaterials();
        System.out.println(allCourseMaterials);
    }




}
