import model.Account;
import model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankApplication {

    public static void printAllCustomers(List<Customer> customers){
        customers.stream()
                .sorted(Comparator.comparing(Customer::getLastName))
                .forEach(e -> System.out.println(e.toJsonFormat()));
    }

    public static void printIsQualified(List<Customer> customers){
        //displayed sorted in descending order of the Accounts’ balance
        //and then Account Number.
        List<Customer> platinumCustomers = customers.stream()
                .filter(Customer::isQualified) // Filter Platinum Account Customers
                .sorted(Comparator
                        .comparing(Customer::getAccount, Comparator
                                .comparing(Account::getBalance, Comparator.reverseOrder())
                                .thenComparing(Account::getAccountNo)))
                .collect(Collectors.toList());

//        List<Customer> platinumCustomers = customers.stream()
//                        .filter(c -> c.isQualified())
//                                .sorted(Comparator.comparing(c->c.getAccount().getBalance())
//                                        .thenComparing(Customer c-> ))

        platinumCustomers.forEach(e -> System.out.println(e.toJsonFormat()));

    }

    public static void main(String[] args) {
        Customer customer1 = new Customer(1L,"Daniel","Agar", LocalDate.of(1978,01,17),"SV1089",LocalDate.of(2013,10,10),950.00);
        Customer customer2 = new Customer(2L,"Benard","Shaw", LocalDate.of(2004,10,20),"CK1007",LocalDate.of(2013,10,9),100005.00);
        Customer customer3 = new Customer(3L,"Carly","DeFiori", LocalDate.of(2014,05,16),"CK1007",LocalDate.of(2019,11,04),1555.50);
        Customer customer4 = new Customer(4L,"Wesley","Schneider", LocalDate.of(2001,11,02),"CK1423",LocalDate.of(2012,1,15),125009.55);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        //1.print in json sorted by lastname ascending order
        printAllCustomers(customers);

        //2
        System.out.println("Is Quilifed Account");
        printIsQualified(customers);
    }
}
