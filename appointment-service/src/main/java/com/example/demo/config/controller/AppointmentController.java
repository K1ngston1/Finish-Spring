package com.example.demo.config.controller;

import com.example.demo.config.dto.AppointmentDetailsDTO;
import com.example.demo.config.model.Appointment;
import com.example.demo.config.model.Doctor;
import com.example.demo.config.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public AppointmentDetailsDTO getAppointmentDetails(@PathVariable String id) {
        return appointmentService.getAppointmentDetailsById(id);
    }


    @GetMapping("/patients")
    public List<Map<String, Object>> getAllPatients() {
        return appointmentService.getAllPatients();
    }

    @GetMapping("/doctors")
    public List<Map<String, Object>> getAllDoctors() {
        return appointmentService.getAllDoctors();
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable String id) {
        appointmentService.deleteDoctor(id);
    }

    @PostMapping("/doctors")
    public Map<String, Object> createDoctor(@RequestBody Doctor doctor) {
        return appointmentService.createDoctor(doctor);
    }

    @PutMapping("/doctors/{id}")
    public Map<String, Object> updateDoctor(@PathVariable String id, @RequestBody Doctor doctor) {
        return appointmentService.updateDoctor(id, doctor);
    }


}

