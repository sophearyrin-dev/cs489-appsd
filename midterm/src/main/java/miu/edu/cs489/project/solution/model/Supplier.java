package miu.edu.cs489.project.solution.model;

import java.util.List;

public class Supplier {

    private Long supplierId;

    private String name;

    private String contactPhone;

    private List<Product> productList;

    public Supplier() {
    }

    public Supplier(Long supplierId, String name, String contactPhone, List<Product> productList) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPhone = contactPhone;
        this.productList = productList;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    //A Star Supplier is a supplier who has supplied at least 2 Products, and the total dollar value of the products supplied is more than $100,000.00
    public boolean isStarSupplier() {
        //1.check product size in each product
        int supplierProductCount = 0;

        //2.check total price of all product for each supplier
        double supplierTotalProductPrice = 0.0;
        if (productList != null) {
            for (Product product : productList) {
                supplierProductCount++;
                supplierTotalProductPrice += product.getQuantitySupplied() * product.getUnitPrice();
            }
        }

        return supplierProductCount >= 2 && supplierTotalProductPrice > 100000.00;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                "\n, productList=" + productList +
                '}';
    }

}
