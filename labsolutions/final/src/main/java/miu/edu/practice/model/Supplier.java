package miu.edu.practice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @NotBlank
    private String name;

    private String contactPhoneNumber;

    //Uni Directional
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "supplier")
    private List<Product> products;


    public boolean isStart(){
        return this.products.size()>=2 && total() >=100000;
    }

    private Double total(){
        return products.stream().mapToDouble(
                p -> p.getUnitPrice() * p.getQuantity()
        ).sum();
    }

    public Supplier(Integer supplierId, String name, String contactPhoneNumber) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
