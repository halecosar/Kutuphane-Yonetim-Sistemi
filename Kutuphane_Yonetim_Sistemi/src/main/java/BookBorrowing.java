import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name= "borrowings")
public class BookBorrowing {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column (name = "borrowing_id" , columnDefinition = "serial")
   private Long id;
   @ Column (name= "borrower_name" , nullable = false)
   private String borrowerName;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_on_date",nullable = false)
    private LocalDate borrowingDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "borrowReturn_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;



    public BookBorrowing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                '}';
    }
}
