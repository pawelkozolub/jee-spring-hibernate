package pl.coderslab.app.book;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.author.AuthorDao;
import pl.coderslab.app.publisher.Publisher;
import pl.coderslab.app.publisher.PublisherDao;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao,PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/get")
    public String get(@RequestParam Long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @PostMapping("/create")
    public String create(@RequestParam String title, @RequestParam Integer rating,
                         @RequestParam Long publisherId, @RequestParam List<Long> authorIds) {
        Publisher publisher = publisherDao.findById(publisherId);
        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setPublisher(publisher);
        for (Long authorId : authorIds) {
            Author author = authorDao.findById(authorId);
            book.getAuthors().add(author);  // getter to retrieve object list, then add(item) is used on it
        }
        bookDao.save(book);
        return book.toString();
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String title, @RequestParam Integer rating) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        book.setRating(rating);
        bookDao.update(book);
        return book.toString();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return book.toString();
    }
}
