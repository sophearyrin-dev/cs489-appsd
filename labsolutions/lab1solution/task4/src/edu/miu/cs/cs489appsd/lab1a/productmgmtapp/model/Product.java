package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product {

    private Long productId;
    private String name;
    private LocalDate dateSupplied;
    private Integer quantityInStock;
    private Double unitPrice;

    //3 constructor


    public Product() {
    }

    public Product(String name, LocalDate dateSupplied, Integer quantityInStock, Double unitPrice) {
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(Long productId, String name, LocalDate dateSupplied, Integer quantityInStock, Double unitPrice) {
        this(name,dateSupplied,quantityInStock,unitPrice);
        this.productId = productId;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
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

//    public String toJsonFormat() {
//        return "    {" +
//                "\"productId\":" + productId +
//                ", \"name\":" + name +
//                ", \"dateSupplied\":" + dateSupplied +
//                ", \"quantityInStock\":" + quantityInStock +
//                ", \"unitPrice\":" + unitPrice +
//                '}'+',';
//    }

    public String toJsonFormat(){
        return String.format("{\"productId\": %d, \"name\":%s, \"dateSupplier\":%s, \"quantityInStock\":%d, \"unitPrice\": %,.2f}",
                productId, name, dateSupplied, quantityInStock, unitPrice);
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






