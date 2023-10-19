package com.example.adsrestapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surgeries")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryId;

    private String name;

    private String phoneNumber;

    @OneToOne()
    @JoinColumn(name = "address_id", unique = true)
    private Address primaryAddress;


    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;

    @Override
    public String toString() {
        return "Surgery{" +
                "surgeryId=" + surgeryId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Surgery(String name, String phoneNumber, Address primaryAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.primaryAddress = primaryAddress;
    }
}
