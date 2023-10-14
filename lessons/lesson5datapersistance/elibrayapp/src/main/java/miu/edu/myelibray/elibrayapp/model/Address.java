package miu.edu.myelibray.elibrayapp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(length = 20)
    private String street;

    private String city;

    private String state;

    @Column(length = 6)
    private String zipCode;

    //bidirectional, mappedBy = "address"(address here is the field in Publisher class)
    @OneToOne(mappedBy = "address")
    private Publisher publisher;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
