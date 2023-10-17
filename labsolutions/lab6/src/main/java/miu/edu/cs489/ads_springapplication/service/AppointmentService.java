package miu.edu.cs489.ads_springapplication.service;

import miu.edu.cs489.ads_springapplication.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> getAllAppointments();

    Appointment addNewAppointment(Appointment appointment);
}
