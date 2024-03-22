package com.example.mongodbexample.repo;

import com.example.mongodbexample.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface StudentRepository extends MongoRepository<Student, Integer>{

}
