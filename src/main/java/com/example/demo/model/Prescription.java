package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescriptions")
public class Prescription {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String medication;
    private String dosage;

    // Getter для id
    public String getId() {
        return id;
    }

    // Setter для id
    public void setId(String id) {
        this.id = id;
    }

    // Getter для patientId
    public String getPatientId() {
        return patientId;
    }

    // Setter для patientId
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    // Getter для doctorId
    public String getDoctorId() {
        return doctorId;
    }

    // Setter для doctorId
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    // Getter для medication
    public String getMedication() {
        return medication;
    }

    // Setter для medication
    public void setMedication(String medication) {
        this.medication = medication;
    }

    // Getter для dosage
    public String getDosage() {
        return dosage;
    }

    // Setter для dosage
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
