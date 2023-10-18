package edu.miu.cs.cs489.lesson6.citylibraryapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
@NamedQuery(name="Book.findScienceBooks", query = "select b from Book b where b.isbn like '978'")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(unique = true)
    private String isbn;
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePublished;

    @ManyToOne
    @JoinColumn(name = "publisher_id", unique = false)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name="books_authors",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name="author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;
}
