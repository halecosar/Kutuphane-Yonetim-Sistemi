import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "publishers")
public class Publisher {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   @Column (name = "publisher_id" , nullable = false , columnDefinition = "serial")
   private Long id;
   @Column (name = "publisher_name" , unique = true)
   private String name;
   @Column (name= "establish_year")
   private  int establishmentYear;



    @ Column (name= "address")
   private String address;

   @OneToMany (mappedBy = "publisher")
   private List<Book> bookList;

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", establishmentYear=" + establishmentYear +
                ", address='" + address + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
