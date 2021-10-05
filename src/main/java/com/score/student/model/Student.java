package com.score.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;
	private Double score;
	
	
	public Student() {
		super();
	}
	public Student(String name, Integer roll, Double score) {
		super();
		this.name = name;
		this.roll = roll;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRoll() {
		return roll;
	}
	public void setRoll(Integer roll) {
		this.roll = roll;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", score=" + score + "]";
	}
	
	
}
