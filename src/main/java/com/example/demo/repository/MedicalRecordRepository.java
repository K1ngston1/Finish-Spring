package com.example.demo.repository;

import com.example.demo.model.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String> {
}
