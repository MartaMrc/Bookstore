package hibernate.project.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.antlr.v4.runtime.misc.NotNull;
//import org.example.converters.BookGenreConverter;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name= "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISBN")
    private int ISBN;
    @Column(name = "titleBook")
    private String titleBook;
    @Column (name= "firstNameAuthor")
    private String firstNameAuthor;
    @Column(name = "lastNameAuthor")
    private String lastNameAuthor;
    private Double priceBook;
    //    @Transient
//    private String fullNameAuthor;
//    @NotNull
//    @Convert(converter = BookGenreConverter.class)
//    private BookGenre bookGenre;

    public Book(String titleBook, String firstNameAuthor, String lastNameAuthor, Double priceBook) {
        this.titleBook = titleBook;
        this.firstNameAuthor = firstNameAuthor;
        this.lastNameAuthor = lastNameAuthor;
        this.priceBook = priceBook;

    }

}