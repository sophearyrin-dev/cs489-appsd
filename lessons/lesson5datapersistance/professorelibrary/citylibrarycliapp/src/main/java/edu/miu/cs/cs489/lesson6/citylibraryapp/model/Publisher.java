package edu.miu.cs.cs489.lesson6.citylibraryapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    @Column(nullable = false)
//    @NotNull(message = "Publisher Name is required and cannot be null") // new Publisher("")
//    @NotEmpty(message = "Publisher Name is required and cannot be null or empty string") //new Publisher(" ")
    @NotBlank(message = "Publisher Name is required and cannot be null or empty string or blank spaces")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true, nullable = true)
    private Address primaryAddress;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public Publisher(Integer publisherId, String name, Address primaryAddress) {
        this.publisherId = publisherId;
        this.name = name;
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Publisher{");
        sb.append("publisherId=").append(publisherId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", primaryAddress=").append(primaryAddress);
        sb.append('}');
        return sb.toString();
    }
}
