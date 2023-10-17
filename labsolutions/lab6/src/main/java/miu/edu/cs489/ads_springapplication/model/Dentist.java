package miu.edu.cs489.ads_springapplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private LocalDate dob;

    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

    public Dentist(String firstName, String lastName, String phoneNumber, String email, LocalDate dob, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "dentistId=" + dentistId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
