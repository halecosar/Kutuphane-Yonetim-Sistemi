import jakarta.persistence.*;

import java.util.List;
import java.util.PrimitiveIterator;

@Entity
@Table (name = "categories")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "category_id", nullable = false , columnDefinition = "serial")
    private int id;
    @Column (name = "category_name" , unique = true)
    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    @Column (name = "category_dscrp")
    private String description;

    @ManyToMany(mappedBy = "categoryList")
    private List<Book> bookList;


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
