package miu.edu.cs489.ads_springapplication.service.imp;

import miu.edu.cs489.ads_springapplication.model.Appointment;
import miu.edu.cs489.ads_springapplication.repository.AppointmentRepository;
import miu.edu.cs489.ads_springapplication.service.AppointmentService;
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
