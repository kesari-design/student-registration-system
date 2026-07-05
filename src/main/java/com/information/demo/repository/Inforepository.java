package com.information.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.information.demo.entity.Student;

@Repository
public interface Inforepository extends JpaRepository<Student,Integer>{

}
           