package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;
import java.util.*;

public class ProductMgmtApp {

    public static void printProducts(List<Product> products){

//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product p1, Product p2) {
//                return p1.getName().compareTo(p2.getName());
//            }
//        });

        //StreamAPI
        products.stream()
                .sorted(Comparator.comparing(Product::getName));
//        .sorted(Comparator.comparing(p->p.getName()));

        int n = products.size();
        System.out.println("\nJSON:\n------");
        System.out.println("[");
        if(products !=null){
            for(Product p: products){

            }
        }
        for(int i=0; i<n; i++){
            System.out.println(products.get(i).toJsonFormat());
        }
        System.out.println("]");

        System.out.println("\nXML Format:\n-------");
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<products>");
        for(Product p: products){
            System.out.println(p.toXMLFormat());
        }
        System.out.println("</products>");
        System.out.println("</xml>");

        System.out.println("\nCSV Format:\n------");
        for (Product product: products){
            System.out.println(product.toCSVFormat());
            System.out.println(product.toCSVFormat());
        }

        System.out.println("\nYAML Format:\n------");
        System.out.println("products:");
        for (Product p:products){
            System.out.println(p.toYMLFormat());
        }
    }
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(3128874119L,"Banana", LocalDate.of(2023,01,24 ),124 ,0.55);
        Product product2 = new Product(2927458265L,"Apple", LocalDate.of(2022,12,9),18 ,1.09);
        Product product3 = new Product(9189927460L,"Carrot ", LocalDate.of(2023,3,31 ),89 ,2.99);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        printProducts(products);
    }

}
