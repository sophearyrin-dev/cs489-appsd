package miu.edu.camsys.camsys614133.onetomany.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "comments")
public class Comment {

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String commentContent;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tutorial_id", nullable = false)
    private Tutorial tutorial;

    public Comment(String commentContent) {
        this.commentContent = commentContent;
    }
}
