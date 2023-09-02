package pl.coderslab.app.publisher;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager em;

    public void save(Publisher entity) {
        em.persist(entity);
    }

    public void update(Publisher entity) {
        em.merge(entity);
    }

    public void delete(Publisher entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public Publisher findById(Long id) {
        return em.find(Publisher.class, id);
    }
}