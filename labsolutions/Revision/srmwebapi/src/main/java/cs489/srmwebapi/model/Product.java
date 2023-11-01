package cs489.srmwebapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    //productNo is require and unique
    @Column(nullable = false, unique = true)
    @NotNull
    private Long productNo;

    //Require
    @Column(nullable = false)
    @NotBlank
    private String name;

    //Optional
    private LocalDate dateSupplied;


    //Optional
    private Integer quantityInStock;

    //Require
    @Column(nullable = false)
    @NotNull
    private Double unitPrice;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;



}
