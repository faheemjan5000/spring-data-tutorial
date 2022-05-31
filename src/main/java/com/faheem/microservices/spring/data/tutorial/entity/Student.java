package com.faheem.microservices.spring.data.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        name="tabl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer studentId;
    private String firstName;
    private String lastName;
    @Column(
            name="email_address",
            nullable = false
    )
    private String email;
    @Embedded //using this annotation because i dont want to create table for this class.
    private Guardian guardian;


    public Student(String firstName, String lastName, String email, Guardian guardian) {
        this.firstName =firstName;
        this.lastName=lastName;
        this.email=email;
        this.guardian=guardian;
    }
}
