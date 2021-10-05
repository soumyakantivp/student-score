package com.score.student.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.score.student.dao.StudentRepo;
import com.score.student.model.Student;


@Service
public class StudentService {
	@Autowired
	StudentRepo repo;
	Integer passMarks = 101;
	public List<Student> sortStudentByScore(){
		List<Student> list = repo.findAll();
		Collections.sort(list, (a, b)->(int)(a.getScore()-b.getScore()));
		return list;
	}
	public Map<String, String> passFailMap(){
		List<Student> list = repo.findAll();
		Map<String, String> pfMap = new HashMap<String,String>();
		for(Student s: list) {
			pfMap.put(s.getName(),(s.getScore()>=passMarks)?"Pass":"Fail");
		}
		return pfMap;
	}
	public Map<String, Integer> passFailCount(){
		List<Student> list = repo.findAll();
		Map<String, Integer> pfCount = new HashMap<String,Integer>();
		int passCount = 0, failCount=0;
		
		for(Student s: list) {
			if(s.getScore()<=passMarks) {
				failCount++;
			}
			else {
				passCount++;
			}
		}
		
		pfCount.put("pass",passCount);
		pfCount.put("fail",failCount);
		return pfCount;
	}
}
