package com.example.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Course course;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student(String name, String address, Course course) {
		this.name = name;
		this.address = address;
		this.course = course;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
}
