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
    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_on_date",nullable = false)
    private LocalDate borrowingDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "borrowReturn_date",nullable = false)
    private LocalDate returnDate;



}
