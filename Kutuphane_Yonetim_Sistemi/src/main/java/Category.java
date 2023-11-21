import jakarta.persistence.*;

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
    @Column (name = "category_dscrp")
    private String description;

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
