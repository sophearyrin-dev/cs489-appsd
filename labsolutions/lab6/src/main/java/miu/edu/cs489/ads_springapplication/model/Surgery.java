package miu.edu.cs489.ads_springapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surgeries")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int surgeryId;

    private String name;

    private String phoneNumber;

    @OneToOne()
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

}
