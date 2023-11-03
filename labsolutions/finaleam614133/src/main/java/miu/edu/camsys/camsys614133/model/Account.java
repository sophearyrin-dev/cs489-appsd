package miu.edu.camsys.camsys614133.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    //required field; unique
    @Column(nullable = false, unique = true)
    @NotBlank
    private String accountNumber;

    //required field
    @Column(nullable = false)
    @NotBlank
    private String accountType;

    //optional field
    private LocalDate dateOpened;

    //required field
    @Column(nullable = false)
    @NotNull
    private Double balance;

    @ManyToMany(mappedBy = "accounts")
    private List<Customer> customers;

    public Account(String accountNumber, String accountType, LocalDate dateOpened, Double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
    }

    public boolean isPrime(){
        return this.balance >= 100000.00;
    }
}
