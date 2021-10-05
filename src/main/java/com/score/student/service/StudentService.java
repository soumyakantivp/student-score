package com.score.student.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		return list.stream().collect(Collectors.toMap(k->k.getName(), v->v.getScore()>=passMarks ? "PASS":"FAIL"));
	}
	public Map<String, Integer> passFailCount(){
		Map<String, Integer> passMap = repo.findAll().stream()
		.filter(s->s.getScore()>=passMarks)
		.collect(Collectors.toMap(k->"PASS", v->1,
				(v1,v2)->v1+v2));
		
		Map<String, Integer> failMap = repo.findAll().stream()
				.filter(s->s.getScore()<passMarks)
				.collect(Collectors.toMap(k->"FAIL", v->1,
						(v1,v2)->v1+v2));
	
		return Stream.concat(passMap.entrySet().stream(),failMap.entrySet().stream())
		.collect(Collectors.toMap(k->k.getKey(), v->v.getValue()));	
	}
}
