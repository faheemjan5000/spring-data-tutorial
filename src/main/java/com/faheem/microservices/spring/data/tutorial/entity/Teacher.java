package com.faheem.microservices.spring.data.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer teacherId;
    private String firstName;
    private String lastName;

    //a teacher can teach multiple courses(1-to-many)
    //generally its better to use Many-to-one relation from the course side. so i comment it and use many to one in course class.
    /*
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER //when you fetch teacher, its course list is fetched as well automatically
               //FetchType.LAZY  when you call courses on demand. i.e call getCourses()..
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;

     */
}
