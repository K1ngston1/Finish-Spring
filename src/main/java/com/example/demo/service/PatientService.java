package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient updatePatient(String id, Patient updatedPatient) {
        Patient patient = getPatientById(id); // перевіряємо чи існує пацієнт
        patient.setName(updatedPatient.getName());
        patient.setAge(updatedPatient.getAge());
        patient.setGender(updatedPatient.getGender());
        patient.setMedicalRecordIds(updatedPatient.getMedicalRecordIds());
        return patientRepository.save(patient);
    }

    public void deletePatient(String id) {
        Patient patient = getPatientById(id); // перевіряємо чи існує пацієнт
        patientRepository.delete(patient);
    }
}
