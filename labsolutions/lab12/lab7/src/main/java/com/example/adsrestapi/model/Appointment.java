package com.example.adsrestapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Appointment(LocalDate date, Surgery surgery, Dentist dentist, Patient patient) {
        this.date = date;
        this.surgery = surgery;
        this.dentist = dentist;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", date=" + date +
                "\n, surgery=" + surgery +
                "\n, dentist=" + dentist +
                "\n, patient=" + patient +
                '}';
    }
}
