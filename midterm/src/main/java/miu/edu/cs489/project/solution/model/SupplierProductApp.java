package miu.edu.cs489.project.solution.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class SupplierProductApp {

    public static void printAllSupplier(List<Supplier> suppliers){
        suppliers.stream()
                .sorted(Comparator.comparing(Supplier::getName))
                .forEach(System.out::println);
    }

    public static void printStarSupplier(List<Supplier> suppliers){
        suppliers.stream()
                .filter(Supplier::isStarSupplier)
                .sorted(Comparator.comparing(Supplier::getName))
                .forEach(System.out::println);

    }
    public static void main(String[] args) {

        Supplier supplier1 = new Supplier(1L, "Google, Inc.", null, List.of(
                new Product(3128874119L, "Pixel 8 Pro", LocalDate.of(2023, 01, 24), 124, 1599.55)
        ));


        Supplier supplier2 = new Supplier(2L,
                "Apple, Inc.", "(641) 123-0987", List.of(
                new Product(2927458265L, "iPad 14 Pro", LocalDate.of(2022, 12, 9), 18, 1700.09),
                new Product(2927458266L, "iPhone 15", LocalDate.of(2023, 10, 11), 95, 1650.85)
        ));

        Supplier supplier3 = new Supplier(3L, "Samsung Corporation", null, null);
        Supplier supplier4 = new Supplier(4L, "Huawei", null, null);


        List<Supplier> suppliers = List.of(supplier1,supplier2,supplier3,supplier4);

        //printStarSupplier
        System.out.println("Output all star suppliers: \n--------------\n");
        printStarSupplier(suppliers);

        //add my own task : printAllSupplier
//        System.out.println("printAllSupplier\n--------------\n");
//        printAllSupplier(suppliers);


    }
}
