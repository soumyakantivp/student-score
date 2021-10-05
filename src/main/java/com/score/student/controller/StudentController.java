package com.score.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.score.student.model.Student;
import com.score.student.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@RequestMapping(value = "report/sort-student", method = RequestMethod.GET)
	public List<Student> getSortedStudents(){
		return service.sortStudentByScore();
	}
	
	@RequestMapping(value = "report/pass-fail-map", method = RequestMethod.GET)
	public Map<String, String> getPassFailMap(){
		return service.passFailMap();
	}
	
	@RequestMapping(value = "report/pass-fail-count", method = RequestMethod.GET)
	public Map<String, Integer> getPassFailCount(){
		return service.passFailCount();
	}
}
