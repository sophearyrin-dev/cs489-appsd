package miu.edu.camsys.camsys614133.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    //required field
    @Column(nullable = false)
    @NotBlank
    private String fistName;

    //required field
    @Column(nullable = false)
    @NotBlank
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "customers_accounts",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "customerId")},
            inverseJoinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "accountId")}
    )
    private List<Account> accounts;


    public Customer(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }
}


