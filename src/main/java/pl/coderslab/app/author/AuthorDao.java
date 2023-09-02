package pl.coderslab.app.author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;    // convention not to use private

    public void save(Author entity) {
        entityManager.persist(entity);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }
}
