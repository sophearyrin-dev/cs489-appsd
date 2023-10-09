package model;

import java.time.LocalDate;

public class Account {

    private String accountNo;

    private LocalDate dateOpened;

    private double balance;

    public Account(String accountNo, LocalDate dateOpened, double balance) {
        this.accountNo = accountNo;
        this.dateOpened = dateOpened;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
