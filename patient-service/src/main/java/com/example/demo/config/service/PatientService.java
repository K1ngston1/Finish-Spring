package com.example.demo.config.service;

import com.example.demo.config.model.Patient;
import com.example.demo.config.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public PatientService(PatientRepository patientRepository, RestTemplate restTemplate) {
        this.patientRepository = patientRepository;
        this.restTemplate = restTemplate;
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

    public String getDoctorNameById(String doctorId) {
        String url = "http://doctor-service/doctors/" + doctorId;
        return restTemplate.getForObject(url, String.class);
    }
}
