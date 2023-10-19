package com.example.adsrestapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    private String fistName;

    private String lastName;

    private String phoneNumber;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true)
    private Address primaryAddress;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(String fistName, String lastName, String phoneNumber, String email, LocalDate dob, Address primaryAddress) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
