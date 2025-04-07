package com.example.demo.config.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "patients")
public class Patient {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String gender;
    private List<String> medicalRecordIds;

    public Patient() {}

    public Patient(String name, Integer age, String gender, List<String> medicalRecordIds) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalRecordIds = medicalRecordIds;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getMedicalRecordIds() {
        return medicalRecordIds;
    }

    public void setMedicalRecordIds(List<String> medicalRecordIds) {
        this.medicalRecordIds = medicalRecordIds;
    }
}
