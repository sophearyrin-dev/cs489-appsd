package cs489.srmwebapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "suppliers")
public class Supplier {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    //name required
    @Column(nullable = false)
    @NotBlank
    private String name;

    //Optional
    @Column(nullable = true)
    private String contactPhoneNumber;

//    @JsonManagedReference
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private List<Product> products;

    public boolean isStarSupplier() {
        return (this.products.size() >= 2 && totalProductsAmount() > 100000.00);
    }

    private Double totalProductsAmount() {
        return products.stream()
                .mapToDouble(p -> p.getUnitPrice() * p.getQuantityInStock())
                .sum();
    }

    public Supplier(Integer supplierId, String name, String contactPhoneNumber) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
