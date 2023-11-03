//package miu.edu.practice.manytomany.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "tutorials")
//public class Tutorial {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer tutorialId;
//
//    private String title;
//
//    @ManyToMany(fetch = FetchType.EAGER,
//    cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(
//            name = "tutorials_tags",
//            joinColumns = {@JoinColumn(name = "tutorial_id", referencedColumnName = "tutorialId")},
//            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "tagId")}
//    )
//    private Set<Tag> tags = new HashSet<>();
//}
