package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String name;
    private int age;
    private String gender;
    private List<String> medicalRecordIds;

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

    // Getter для age
    public int getAge() {
        return age;
    }

    // Setter для age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter для gender
    public String getGender() {
        return gender;
    }

    // Setter для gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter для medicalRecordIds
    public List<String> getMedicalRecordIds() {
        return medicalRecordIds;
    }

    // Setter для medicalRecordIds
    public void setMedicalRecordIds(List<String> medicalRecordIds) {
        this.medicalRecordIds = medicalRecordIds;
    }
}
