package model;

import java.time.LocalDate;

public class Customer {

    private Long customerId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfDate;

    private Account account;


    public Customer(Long customerId, String firstName, String lastName, LocalDate dateOfDate,
                    String accountNo, LocalDate dateOpened,double balance) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfDate = dateOfDate;
        this.account = new Account(accountNo, dateOpened,balance);
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfDate() {
        return dateOfDate;
    }

    public void setDateOfDate(LocalDate dateOfDate) {
        this.dateOfDate = dateOfDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    //Note:A Platinum Account Customer is a customer whose
    // Account was opened at least 10 years ago,
    // and the Account balance is at least $100,000
    public boolean isQualified(){
        //at least 10 year,
        //example : date open 2013-10-10
        //get current date
        LocalDate nowDate = LocalDate.now();
        int yearNow = nowDate.getYear();
        int yearOpenAccount = account.getDateOpened().getYear();

        //another condition: and the Account balance is at least $100,000
        if(yearNow - yearOpenAccount >= 10 && account.getBalance() >=100000){
            return true;
        }
//        System.out.println("nowDate" + nowDate);
        return false;
    }


    public String toJsonFormat(){
        return String.format("{\"CustomerId\": %d, \"AccountNo\":%s, \"firstname\":%s, \"lastname\":%s, \"dob\": %s, \"DateAccountOpened\": %s, \"accountBalance\": %,.2f}",
                customerId, account.getAccountNo(), firstName, lastName, dateOfDate, account.getDateOpened(), account.getBalance());
    }
}
