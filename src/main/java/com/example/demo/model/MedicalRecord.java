package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medical_records")
public class MedicalRecord {
    @Id
    private String id;
    private String patientId;
    private String diagnosis;
    private String treatment;
    private String doctorId;

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

    // Getter для diagnosis
    public String getDiagnosis() {
        return diagnosis;
    }

    // Setter для diagnosis
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    // Getter для treatment
    public String getTreatment() {
        return treatment;
    }

    // Setter для treatment
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    // Getter для doctorId
    public String getDoctorId() {
        return doctorId;
    }

    // Setter для doctorId
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
