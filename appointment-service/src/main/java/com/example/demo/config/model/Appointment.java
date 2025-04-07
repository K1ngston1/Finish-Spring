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
    private LocalDateTime dateTime;
    private String description;


    public Appointment() {}

    public Appointment(String patientId, String doctorId, LocalDateTime dateTime, String description) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.description = description;
    }


    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPatientId() { return patientId; }

    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDoctorId() { return doctorId; }

    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getDateTime() { return dateTime; }

    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
