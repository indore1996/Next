package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/list")
	public ResponseEntity<Page<Student>> getAllStudents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy){
		Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));
		Page<Student> students = studentRepository.findAll(pageable);
		return ResponseEntity.ok().body(students);
	} 
	
	
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		/*
		 * Course course = student.getCourse(); course.setStudent(student);
		 * courseRepository.save(course);
		 */
		return studentRepository.save(student);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student>updateStudent(@PathVariable Long id, @RequestBody Student studentDetail) throws Exception{
		Student student  = studentRepository.findById(id).orElseThrow(()-> new Exception("no data"));
		
		student.setName(studentDetail.getName());
		student.setAddress(studentDetail.getAddress());
		student.setCourse(studentDetail.getCourse());
		
		Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	public void delete(@PathVariable Long id) throws Exception{
		Student student = studentRepository.findById(id).orElseThrow(()->new Exception("Not found"+ id));
		courseRepository.delete(student.getCourse());
		studentRepository.delete(student);
	}
}
