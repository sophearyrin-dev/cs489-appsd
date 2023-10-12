package miu.edu.cs489.project.solution.model;

import java.time.LocalDate;

public class Product {

    private Long productNo;

    private String name;

    private LocalDate dateSupplied;

    private int quantitySupplied;

    private double unitPrice;

    Product(){}

    Product(Long productNo, String name, LocalDate dateSupplied, int quantitySupplied, double unitPrice) {
        this.productNo = productNo;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantitySupplied = quantitySupplied;
        this.unitPrice = unitPrice;
    }

    public Long getProductNo() {
        return productNo;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantitySupplied() {
        return quantitySupplied;
    }

    public void setQuantitySupplied(int quantitySupplied) {
        this.quantitySupplied = quantitySupplied;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "productNo=" + productNo +
                ", name='" + name + '\'' +
                ", dateSupplied=" + dateSupplied +
                ", quantitySupplied=" + quantitySupplied +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
