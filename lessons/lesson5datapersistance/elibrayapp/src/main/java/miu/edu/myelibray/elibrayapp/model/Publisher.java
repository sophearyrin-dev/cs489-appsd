package miu.edu.myelibray.elibrayapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherId;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", unique = true, nullable=false)
    private Address address;

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
