package com.faheem.microservices.spring.data.tutorial;

import com.faheem.microservices.spring.data.tutorial.entity.Guardian;
import com.faheem.microservices.spring.data.tutorial.entity.Student;
import com.faheem.microservices.spring.data.tutorial.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataTutorialApplicationTests {


	@Autowired
	StudentService studentService;
	@Test
	void contextLoads() {
	}

	@Test
	public void saveeStudent(){
		Guardian guardian = new Guardian("nana","nana@gmail.com","7363882");
		Student student = Student.builder()
				.firstName("irfan")
				.lastName("lala")
				.email("irfan@gmail.com")
				.guardian(guardian)
				.build();
		System.out.println("hello world");
		studentService.save(student);
	}
}
