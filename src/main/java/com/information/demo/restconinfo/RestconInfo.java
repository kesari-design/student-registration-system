package com.information.demo.restconinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.information.demo.entity.Student;
import com.information.demo.infoservice.Serviceinfo;

@RestController
public class RestconInfo {

	@Autowired
	Serviceinfo serv;
	
	@PostMapping("/post")
	public Student save(@RequestBody Student student) {
		return serv.saveinfo(student);
	}
	
	@GetMapping("/fetch")
	public List<Student> fetch() {
		return serv.fetch();
	}
	@GetMapping("/fetch/{id}")
	public  Student fetchbyid(@PathVariable int id){
		return serv.fetchbyid(id);
	}
	@PutMapping("/update/{id}")
	public Student updatebyid(@PathVariable int id,@RequestBody Student stu) {
		return serv.updatebyid(id,stu);
	}
	@DeleteMapping("/delete/{id}")
	public String deletebyid(@PathVariable int id) {
		return serv.deletebyid(id);
	}
	
		
}
