package com.faheem.microservices.spring.data.tutorial.repository;

import com.faheem.microservices.spring.data.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

      List<Student> findByFirstName(String firstName);

      List<Student> findByFirstNameContaining(String pattern);

      List<Student> findByGuardianName(String guardianName);

      Student findByFirstNameAndLastName(String firstName , String lastName);


      //JPQL queries : use attributes and class names not table
      @Query("SELECT s FROM Student s WHERE s.email = ?1")//by 1 we mean the first argument (emailAddress)
      Student getStudentByEmailAddress(String emailAddress); //this method is not exist so we write qeury for it.

      @Query("SELECT s.firstName FROM Student s WHERE s.email = ?1") //to get just the first name
      String getStudentFirstNameByEmailAddress(String emailAddress);


      //in the case if the qeuries are complex you can use native(sql) queries as well.here use table n column names
      @Query(
              value = "SELECT * " +
                      "FROM tabl_student s " +
                      "WHERE s.email_address =?1",
              nativeQuery = true
      )
      Student getStudentByEmailAddressNativeQueryExample(String emailAddress);




}
