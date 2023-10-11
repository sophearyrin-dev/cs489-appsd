package edu.miu.cs.cs489.quiz1.bankingcliapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
public class Account {
    private String accountNo;
    private LocalDate dateOpened;
    private Double balance;

    Account(String accountNo, LocalDate dateOpened, Double balance) {
        this.accountNo = accountNo;
        this.dateOpened = dateOpened;
        this.balance = balance;
    }

    public boolean isPlatinum() {
        return ((Period.between(dateOpened, LocalDate.now())
                .getYears() >= 10) &&(balance >= 100000.00));
    }
}
