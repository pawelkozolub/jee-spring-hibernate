package pl.coderslab.app.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.category.Category;
import pl.coderslab.app.publisher.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> gimmeBookWithTitle(String title);

    List<Book> findAllByCategory(Category category);

    @Query("SELECT b FROM Book b WHERE b.category = ?1")
    List<Book> gimmeBookWithCategory(Category category);

    List<Book> findAllByCategory_Id(Long categoryId);

    List<Book> findAllByCategory_Name(String categoryName);

    List<Book> findAllByAuthorsContains(Author author);             // contains > for the list of authors

    List<Book> findAllByPublisherEquals(Publisher publisher);       // equals > publisher is a single field
    List<Book> findAllByPublisherIn(List<Publisher> publisherList); // if publisher list is provided

    List<Book> findAllByRating(Integer rating);

    Book findFirstBookByCategoryOrderByTitle(Category categoryName);
}
