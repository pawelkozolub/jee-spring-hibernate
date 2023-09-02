package pl.coderslab.app.book;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.publisher.Publisher;
import pl.coderslab.app.publisher.PublisherDao;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao,PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/get")
    public String get(@RequestParam Long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @PostMapping("/create")
    public String create(@RequestParam String title, @RequestParam Integer rating, @RequestParam Long publisherId) {
        Publisher publisher = publisherDao.findById(publisherId);
        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
        book.setPublisher(publisher);
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
