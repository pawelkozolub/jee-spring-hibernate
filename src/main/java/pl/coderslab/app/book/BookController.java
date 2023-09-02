package pl.coderslab.app.book;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/get")
    public String get(@RequestParam Long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @PostMapping("/create")
    public String create(@RequestParam String title, @RequestParam Integer rating) {
        Book book = new Book();
        book.setTitle(title);
        book.setRating(rating);
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
