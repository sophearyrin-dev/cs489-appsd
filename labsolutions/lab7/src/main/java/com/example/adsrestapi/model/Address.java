package com.example.adsrestapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(length = 20)
    private String street;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String state;

    @Column(length = 5)
    private String zipCode;

    @OneToOne(mappedBy = "primaryAddress")
    private Surgery surgery;

    @OneToOne(mappedBy = "primaryAddress")
    private Patient patient;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Integer addressId, String street, String city, String state, String zipCode) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
