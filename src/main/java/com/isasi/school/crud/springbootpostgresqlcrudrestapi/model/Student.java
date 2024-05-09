package com.isasi.school.crud.springbootpostgresqlcrudrestapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	//@NotEmpty(message = "Name must not be empty")
	private String name;
	
	//@NotEmpty(message = "DOB must not be empty")
	private Date dob;
	
	//@NotEmpty(message = "DOJ must not be empty")
	private Date doj;
	
	//@NotEmpty(message = "Class name must not be empty")
	private String className;
	
	public Student() {
	}
	
	public Student(long id, String name, Date dob, Date doj, String className) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.className = className;
	}

	@Column(name="id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name="doj")
	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Column(name="class_name")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", doj=" + doj + ", className=" + className
				+ "]";
	}
	
	
	
	
}
