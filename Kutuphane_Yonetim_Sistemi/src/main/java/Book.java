import jakarta.persistence.*;

import java.util.List;

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

    private List<BookBorrowing> getBorrowerList() {
        return borrowerList;
    }

    public void setBorrowerList(List<BookBorrowing> borrowerList) {
        this.borrowerList = borrowerList;
    }


    @OneToMany (mappedBy = "book")
    private List<BookBorrowing> borrowerList;

    @ManyToOne
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;



    @ManyToOne
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book2cat",
            joinColumns = {@JoinColumn(name = "book2cat_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2cat_category_id")}
    )
    private List<Category> categoryList;




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

   @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                '}';
    }
}

