package pl.coderslab.app.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.category.Category;
import pl.coderslab.app.publisher.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByCategory_Id(Long categoryId);

    List<Book> findAllByCategory_Name(String categoryName);

    List<Book> findAllByAuthorsContains(Author author);

    List<Book> findAllByPublisherContains(Publisher publisher);

    List<Book> findAllByRating(Integer rating);

    Book findFirstBookByCategoryOrderByTitle(Category categoryName);
}
