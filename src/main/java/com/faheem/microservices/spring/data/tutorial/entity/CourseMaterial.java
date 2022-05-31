package com.faheem.microservices.spring.data.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "course")
public class CourseMaterial {

    @SequenceGenerator(
            name ="courseMaterial_sequence",
            sequenceName = "courseMaterial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterial_sequence"
    )
    @Id
    private Long courseMaterialId;
    private String courseMaterialUrl;

    @OneToOne( // here it means that only courseMaterial pointing to course(unidirectional)
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY // fetch only this object not other objects with whom it makes relations
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course; //in Course class write this identifier in mappedBye
}
