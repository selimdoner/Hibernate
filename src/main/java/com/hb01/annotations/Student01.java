package com.hb01.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_student01")
public class Student01 {
	
	/*
	 * @Id annotation makes variable primary key
	 * it uniquely identifies each row in a table
	 * it must be unique
	 * can not contain NULL values
	 */
	@Id
	private int id;
	
    @Column(name="student_name",length=100,nullable=false, unique = false) 
	private String name;
    
    //@Transient
    
    private int grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student01 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
    
	
}
