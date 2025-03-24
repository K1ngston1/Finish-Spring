package com.example.demo.repository;

import com.example.demo.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {
}
