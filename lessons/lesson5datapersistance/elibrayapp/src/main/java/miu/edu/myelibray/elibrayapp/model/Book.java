package miu.edu.myelibray.elibrayapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    //TODO: @ManyToOne: Many books to one Publisher
    @JoinColumn(name = "publisher_id", unique = false, nullable=true)
    @ManyToOne
    private Publisher publisher;

    //Note: the code in JoinTable is optional
    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id",referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;




}
