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
public class Course {

    @SequenceGenerator(
            name ="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Id
    private Integer courseId;
    private String title;
    private Integer credit;

    @OneToOne( //now it becomes bidirectional its getting now courseMaterials as well.
            mappedBy = "course" //it's already present  in CourseMaterial so just add mapped by here.
    )
    private CourseMaterial courseMaterial;

    //many courses can be taught by a single teacher
    @ManyToOne(
            cascade = CascadeType.ALL //all related tables will be saved or deleted when called.
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    //relation between course and students
    @ManyToMany()
    @JoinTable(
           name = "course_student_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
                    ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    List<Student> students;


}
