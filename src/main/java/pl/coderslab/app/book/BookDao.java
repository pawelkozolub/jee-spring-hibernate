package pl.coderslab.app.book;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book entity) {
        entityManager.persist(entity);
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public void delete(Book entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);

        // Alternative to @ManyToMany(fetch = FetchType.EAGER)    // to get authors data
//        Book book = entityManager.find(Book.class, id);
//        Hibernate.initialize(book.getAuthors());
//        return book;
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();

//        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class); // prepare stmt
//        List<Book> books = query.getResultList(); // execute stmt
//        return books;
    }

    public List<Book> findAllByRating(Integer rating) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :rating", Book.class)
                .setParameter("rating", rating)
                .getResultList();

//        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :rating", Book.class);
//        query.setParameter("rating", rating);
//        List<Book> books = query.getResultList();
//        return books;
    }
}
