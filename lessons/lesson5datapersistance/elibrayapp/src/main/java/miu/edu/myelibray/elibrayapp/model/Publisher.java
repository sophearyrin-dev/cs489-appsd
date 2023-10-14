package miu.edu.myelibray.elibrayapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

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

    //TODO: joinColumn for FK, nullable=true: address of Publisher can be null
    @OneToOne
    @JoinColumn(name = "address_id", unique = true, nullable=true)
    private Address address;


    //TODO: @OneToMany: one Publisher to Many books
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
