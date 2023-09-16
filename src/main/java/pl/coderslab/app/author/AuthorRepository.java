package pl.coderslab.app.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getByEmail(String email);
    Optional<Author> findByEmail(String email);

    Author getByPesel(String pesel);
    Optional<Author> findByPesel(String pesel);

    List<Author> findAllByLastName(String lastName);
}
