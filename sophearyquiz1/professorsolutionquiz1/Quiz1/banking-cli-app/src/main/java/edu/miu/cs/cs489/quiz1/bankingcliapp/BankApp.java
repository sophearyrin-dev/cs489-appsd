package edu.miu.cs.cs489.quiz1.bankingcliapp;

import edu.miu.cs.cs489.quiz1.bankingcliapp.model.Customer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankApp {

    public static void main(String[] args) {
        System.out.println("Hello Quiz1 - Banking CLI App");
        var customers = List.of(
                new Customer(1L, "Daniel", "Agar",
                        LocalDate.of(1978, 1, 17), "SV1089",
                        LocalDate.of(2013, 10, 10), 950.00),
                new Customer(2L, "Benard", "Shaw",
                        LocalDate.of(2004, 10, 20), "CK1007",
                        LocalDate.of(2013, 10, 9), 100005.00),
                new Customer(1L, "Daniel", "Agar",
                        LocalDate.of(1978, 1, 17), "SV1089",
                        LocalDate.of(2013, 10, 10), 950.00),
            new Customer(1L, "Daniel", "Agar",
                LocalDate.of(1978, 1, 17), "SV1089",
                LocalDate.of(2013, 10, 10), 950.00)

        );
//        new BankApp().printAllCustomers(customers);
        new BankApp().printPlatinumAccountCustomers(customers);
    }

    private void printAllCustomers(List<Customer> customers) {
        if(customers.size() > 0) {
            System.out.println("[");
            var sortedCustomers = customers.stream()
                    .sorted(Comparator.comparing(Customer::getLastName));
//            sortedCustomers.forEach(customer -> System.out.println(customer.toJSONString()));
            System.out.println(sortedCustomers.map(c -> c.toJSONString())
                            .collect(Collectors.joining(",")));
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }

    private void printPlatinumAccountCustomers(List<Customer> customers) {
        if(customers.size() > 0) {
            System.out.println("[");
            var customersSortedByBalanceDesc = customers.stream()
                    .filter(c -> c.getAccount().isPlatinum())
                    .sorted(Comparator.comparing(c -> c.getAccount().getBalance(), Comparator.reverseOrder()));
            // TODO look into compile error when chaining thenComparing
            // Alternatively, we do as below i.e. split into two separate sort steps/statements
            var customersSortedByBalanceDescAndAccountNo = customersSortedByBalanceDesc
                    .sorted(Comparator.comparing(c -> c.getAccount().getAccountNo()));
            System.out.println(customersSortedByBalanceDescAndAccountNo.map(c -> c.toJSONString())
                    .collect(Collectors.joining(",")));
            System.out.println("]");
        } else {
            System.out.println("[]");
        }
    }

}
