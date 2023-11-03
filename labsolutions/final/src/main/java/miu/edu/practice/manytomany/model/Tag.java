//package miu.edu.practice.manytomany.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import miu.edu.camsys.camsys614133.manytomany.model.Tutorial;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "tags")
//public class Tag {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer tagId;
//
//    private String tagName;
//
//    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//    mappedBy = "tags")
//    private Set<Tutorial> tutorials = new HashSet<>();
//}
