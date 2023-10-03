package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product {

    private long productId;
    private String name;
    private LocalDate dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    public Product() {
    }

    public Product(long productId, String name, LocalDate dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "\"productId\"" + productId +
                ", name='" + name + '\'' +
                ", dateSupplied=" + dateSupplied +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public String toJsonFormat() {
        return "    {" +
                "\"productId\":" + productId +
                ", \"name\":" + name +
                ", \"dateSupplied\":" + dateSupplied +
                ", \"quantityInStock\":" + quantityInStock +
                ", \"unitPrice\":" + unitPrice +
                '}'+',';
    }


    public String toXMLFormat(){
            return "  <product>\n"
            +"    <productId>" + productId + "</id>\n"
            +"    <name>" + name + "</name>\n"
            +"    <dateSupplied>" + dateSupplied + "</dateSupplied>\n"
            +"    <quantityInStock>" + quantityInStock + "</quantityInStock>\n"
            +"    <unitPrice>" + unitPrice + "</unitPrice>\n"
            +"  </product>";
        }

    public String toCSVFormat(){
        return productId +", "+ name +", " + dateSupplied + ", "+ quantityInStock + ", " + unitPrice;
    }

    public String toYMLFormat(){
        return "  product:\n"
                +"    id: " + productId + "\n"
                +"    name: " + getName() + "\n"
                +"    dateSupplied: " + dateSupplied + "\n"
                +"    quantityInStock: " + quantityInStock + "\n"
                +"    unitPrice: " + unitPrice + "\n";

    }

}






