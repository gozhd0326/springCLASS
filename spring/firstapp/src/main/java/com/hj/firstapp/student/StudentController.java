package com.hj.firstapp.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	//studentcontroller를 사용하려면 student가 있어야함(의존성)(강한결합)
	//http://localhost:8080/student
	@GetMapping("/student")
	//bean이기 때문에 따로 import할 필요 없이 사용가능함
	public Student getStudent() {
		return new Student("Tom","Jones"); //생성자
	}
	
	//http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Tom","Smith"));
		students.add(new Student("John","Long"));
		students.add(new Student("Steve","White"));
		students.add(new Student("Leon","Red"));
		students.add(new Student("Mike","Tyson"));
		return students;
		
	}
	
	//http://localhost:8080/student/{firstName}/{lastName}
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable String firstName, @PathVariable String lastName) {
		return new Student(firstName, lastName);
	}
	
	
	//http://localhost:8080/student/query
@GetMapping("/student/query")
public Student studentQueryParam(
		@RequestParam(name = "firstName") String firstName,
		@RequestParam(name = "lastName") String lastName
		) {
	return new Student(firstName,lastName);
}

// /student/query?firstName = seo&lastName=tom
}
