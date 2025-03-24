package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "doctors")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String specialization;

    // Getter для id
    public String getId() {
        return id;
    }

    // Setter для id
    public void setId(String id) {
        this.id = id;
    }

    // Getter для name
    public String getName() {
        return name;
    }

    // Setter для name
    public void setName(String name) {
        this.name = name;
    }

    // Getter для specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter для specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}