import jakarta.persistence.*;

@Entity
@Table (name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    @Column (name= "book_id", nullable = false)
    private Long id;

    @Column (name= "book_name" , nullable = false , unique = true)
    private String bookName;

    @Column (name= "publication_year")
    private int publicationYear;

    @Column (name= "stock", nullable = false)
    private int stock;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

  /* @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                '}';
    } */
}

