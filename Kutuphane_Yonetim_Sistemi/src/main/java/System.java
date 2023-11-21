import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class System {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LibraryMS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Author author = new Author();
        author.setName("Victor HUGO");
        author.setBirthday(LocalDate.now());
        author.setCountry("France");
        entityManager.persist(author);

        Publisher publisher= new Publisher();
        publisher.setName("Can Kitabevi");
        publisher.setAddress("İstanbul");
        publisher.setEstablishmentYear(2000);
        entityManager.persist(publisher);

        Book book = new Book();
        book.setBookName("Sefiller");
        book.setStock(10);
        book.setPublicationYear(1862);
        book.setAuthor(author);
        book.setPublisher(publisher);
        entityManager.persist(book);

        Category category = new Category();
        category.setDescription("novel");
        category.setName("Best Sellers");
        entityManager.persist(category);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Hale Cosar");
        bookBorrowing.setBook(book);
        bookBorrowing.setBorrowingDate(LocalDate.now());
        bookBorrowing.setReturnDate(null);
        entityManager.persist(bookBorrowing);

        Book bookcat = entityManager.find(Book.class,book.getId());
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        bookcat.setCategoryList(categories);





        transaction.commit();
    }
}
