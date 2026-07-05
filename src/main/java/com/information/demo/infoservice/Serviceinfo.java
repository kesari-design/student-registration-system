package com.information.demo.infoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.information.demo.entity.Student;
import com.information.demo.exceptionhanle.StudentNotFoundException;
import com.information.demo.repository.Inforepository;

@Service
public class Serviceinfo {

	@Autowired
	Inforepository repository;
	
	public Student saveinfo(Student saved) {
		return repository.save(saved);
	}
	
	public List<Student> fetch() {
		return repository.findAll();
	}
	public  Student fetchbyid(int id){
		return repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Sorry we are unable to fetch... Because The Student with ID " +id+ " not found"));
	}
	public Student updatebyid(int id,Student stu) {
		Student exist=repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Can't update... Becuase The Student with ID " +id+ " not found"));
		if(exist!=null) {
			exist.setName(stu.getName());
			exist.setEmail(stu.getEmail());
			exist.setPhone(stu.getPhone());
			return repository.save(exist);
		}
		return null;
	}
	public String deletebyid(int id) {
//		Student student=repository.findById(id).orElse(null);
		if(!repository.existsById(id)) {
			throw new StudentNotFoundException("This ID " +id+ " is not in the collection");
		}
		repository.deleteById(id);
		return "Student with ID "+id+ " Deleted successfully";
	}
}
