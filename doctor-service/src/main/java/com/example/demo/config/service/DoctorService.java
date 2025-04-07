package com.example.demo.config.service;

import com.example.demo.config.model.Doctor;
import com.example.demo.config.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(String id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctor(String id) {
        doctorRepository.deleteById(id);
    }
}
