package com.example.adsrestapi.service.imp;

import com.example.adsrestapi.model.Appointment;
import com.example.adsrestapi.repository.AppointmentRepository;
import com.example.adsrestapi.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appointmentServiceImp implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public appointmentServiceImp(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
