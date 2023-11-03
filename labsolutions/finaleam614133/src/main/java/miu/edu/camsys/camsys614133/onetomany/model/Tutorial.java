package miu.edu.camsys.camsys614133.onetomany.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tutorials")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tutorialId;

    private String title;

    public Tutorial(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "tutorial")
    List<Comment> comments;
}
