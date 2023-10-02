package org.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.BookType;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name= "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISBN")
    private int ISBN;

    @Column(name = "title_book")
    private String titleBook;

    @Column (name= "first_name_author")
    private String firstNameAuthor;

    @Column(name = "last_name_author")
    private String lastNameAuthor;

    @Column(name = "price_book")
    private Double priceBook;

    @Enumerated(EnumType.ORDINAL)
    private BookType bookType;

    public Book(String titleBook, String firstNameAuthor, String lastNameAuthor, Double priceBook) {
        this.titleBook = titleBook;
        this.firstNameAuthor = firstNameAuthor;
        this.lastNameAuthor = lastNameAuthor;
        this.priceBook = priceBook;

    }

}

