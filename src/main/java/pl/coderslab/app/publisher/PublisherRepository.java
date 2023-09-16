package pl.coderslab.app.publisher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher getByNip(String nip);
    Optional<Publisher> findByNip(String nip);

    Publisher getByRegon(String regon);
    Optional<Publisher> findByRegon(String regon);
}
