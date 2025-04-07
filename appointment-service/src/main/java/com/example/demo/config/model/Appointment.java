package com.example.demo.config.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "appointments")
public class Appointment {

    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private LocalDateTime date;
    private String notes;

    public Appointment() {}

    public Appointment(String patientId, String doctorId, LocalDateTime date, String notes) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
