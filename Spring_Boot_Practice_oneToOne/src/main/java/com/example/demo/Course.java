package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String courseName;
	private String description;
	
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course(String courseName, String description, Student student) {
		this.courseName = courseName;
		this.description = description;
		this.student = student;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	
}
