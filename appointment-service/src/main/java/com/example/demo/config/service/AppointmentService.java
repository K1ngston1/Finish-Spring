package com.example.demo.config.service;

import com.example.demo.config.dto.AppointmentDetailsDTO;
import com.example.demo.config.model.Appointment;
import com.example.demo.config.model.Doctor;
import com.example.demo.config.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public AppointmentDetailsDTO getAppointmentDetailsById(String id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        String patientUrl = "http://localhost:8082/patients/" + appointment.getPatientId();
        String doctorUrl = "http://localhost:8083/doctors/" + appointment.getDoctorId();

        System.out.println("Getting patient details from: " + patientUrl);
        System.out.println("Getting doctor details from: " + doctorUrl);

        Map<String, Object> patient = null;
        Map<String, Object> doctor = null;

        try {
            patient = restTemplate.exchange(patientUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, Object>>() {}).getBody();
        } catch (Exception e) {
            System.out.println("Error getting patient details: " + e.getMessage());
        }

        try {
            doctor = restTemplate.exchange(doctorUrl, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, Object>>() {}).getBody();
        } catch (Exception e) {
            System.out.println("Error getting doctor details: " + e.getMessage());
        }

        return new AppointmentDetailsDTO(
                appointment.getId(),
                appointment.getPatientId(),
                patient != null ? (String) patient.get("name") : "Unknown",
                appointment.getDoctorId(),
                doctor != null ? (String) doctor.get("name") : "Unknown",
                appointment.getDate(),
                appointment.getNotes()
        );
    }

    public List<Map<String, Object>> getAllPatients() {
        String url = "http://localhost:8082/patients";
        try {
            return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Map<String, Object>>>() {}).getBody();
        } catch (Exception e) {
            logger.error("Error getting patients from '{}': {}", url, e.getMessage(), e);  // Логування помилки
            return null;
        }
    }

    public List<Map<String, Object>> getAllDoctors() {
        String url = "http://localhost:8083/doctors";
        try {
            return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Map<String, Object>>>() {}).getBody();
        } catch (Exception e) {
            logger.error("Error getting doctors from '{}': {}", url, e.getMessage(), e);  // Логування помилки
            return null;
        }
    }

    public Map<String, Object> createDoctor(Doctor doctor) {
        String url = "http://localhost:8083/doctors";
        try {
            return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(doctor), new ParameterizedTypeReference<Map<String, Object>>() {}).getBody();
        } catch (Exception e) {
            logger.error("Error creating doctor at '{}': {}", url, e.getMessage(), e);
            return null;
        }
    }

    public Map<String, Object> updateDoctor(String id, Doctor doctor) {
        String url = "http://localhost:8083/doctors/" + id;
        try {
            return restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(doctor), new ParameterizedTypeReference<Map<String, Object>>() {}).getBody();
        } catch (Exception e) {
            logger.error("Error updating doctor at '{}': {}", url, e.getMessage(), e);
            return null;
        }
    }


    public void deleteDoctor(String id) {
        String url = "http://localhost:8083/doctors/" + id;
        try {
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
        } catch (Exception e) {
            logger.error("Error deleting doctor at '{}': {}", url, e.getMessage(), e);
        }
    }

}
