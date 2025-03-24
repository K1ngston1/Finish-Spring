package com.example.demo.controller;

import com.example.demo.model.MedicalRecord;
import com.example.demo.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    // Метод для додавання нового медичного запису
    @PostMapping
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }

    // Метод для отримання всіх медичних записів
    @GetMapping
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

    // Метод для отримання медичного запису за ID
    @GetMapping("/{id}")
    public MedicalRecord getMedicalRecord(@PathVariable String id) {
        return medicalRecordService.getMedicalRecordById(id);
    }

    // Метод для оновлення медичного запису
    @PutMapping("/{id}")
    public MedicalRecord updateMedicalRecord(@PathVariable String id, @RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.updateMedicalRecord(id, medicalRecord);
    }

    // Метод для видалення медичного запису
    @DeleteMapping("/{id}")
    public void deleteMedicalRecord(@PathVariable String id) {
        medicalRecordService.deleteMedicalRecord(id);
    }
}
