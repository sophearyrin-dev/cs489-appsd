package miu.edu.myelibray.elibrayapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(length = 9, unique = true)
    private String isbn;

    private String title;

    private LocalDate datePublished;

    @JoinColumn(name = "publisher_id", unique = false, nullable=true)
    @ManyToOne
    private Publisher publisher;

    //TODO: @ManyToOne: Many books to one Publisher


}
