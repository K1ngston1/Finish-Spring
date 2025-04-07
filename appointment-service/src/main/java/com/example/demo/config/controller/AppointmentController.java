package com.example.demo.config.controller;

import com.example.demo.config.model.Appointment;
import com.example.demo.config.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable String id) {
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable String id, @RequestBody Appointment appointment) {
        appointment.setId(id);
        return appointmentService.saveAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable String id) {
        appointmentService.deleteAppointment(id);
    }
}
