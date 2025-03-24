package com.example.demo.service;

import com.example.demo.model.MedicalRecord;
import com.example.demo.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Autowired
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord getMedicalRecordById(String id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordRepository.findById(id);
        return medicalRecord.orElseThrow(() -> new RuntimeException("Medical record not found"));
    }

    // Метод для оновлення медичного запису
    public MedicalRecord updateMedicalRecord(String id, MedicalRecord updatedRecord) {
        MedicalRecord medicalRecord = getMedicalRecordById(id); // перевіряємо чи існує запис
        medicalRecord.setDiagnosis(updatedRecord.getDiagnosis());
        medicalRecord.setTreatment(updatedRecord.getTreatment());
        medicalRecord.setDoctorId(updatedRecord.getDoctorId());
        medicalRecord.setPatientId(updatedRecord.getPatientId());
        return medicalRecordRepository.save(medicalRecord);
    }

    // Метод для видалення медичного запису
    public void deleteMedicalRecord(String id) {
        MedicalRecord medicalRecord = getMedicalRecordById(id); // перевіряємо чи існує запис
        medicalRecordRepository.delete(medicalRecord);
    }
}
