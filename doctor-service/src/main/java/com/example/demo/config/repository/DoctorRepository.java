package com.example.demo.config.repository;
import com.example.demo.config.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface DoctorRepository extends MongoRepository<Doctor, String> {

}
