package com.example.adsrestapi.service;


import com.example.adsrestapi.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment addNewAppointment(Appointment appointment);
}
