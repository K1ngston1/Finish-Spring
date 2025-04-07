package com.example.demo.config.service;
import com.example.demo.config.model.Patient;
import com.example.demo.config.model.Patient;
import com.example.demo.config.repository.PatientRepository;
import com.example.demo.config.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(String id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public void deletePatient(String id) {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
}
