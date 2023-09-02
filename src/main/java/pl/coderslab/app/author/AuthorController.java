package pl.coderslab.app.author;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.book.Book;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/get")
    public String get(@RequestParam Long id) {
        Book author = authorDao.findById(id);
        return author.toString();
    }

    @PostMapping("/create")
    public String create(@RequestParam String title, @RequestParam Integer rating) {
        Book author = new Book();
        author.setTitle(title);
        author.setRating(rating);
        authorDao.save(author);
        return author.toString();
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String title, @RequestParam Integer rating) {
        Book author = authorDao.findById(id);
        author.setTitle(title);
        author.setRating(rating);
        authorDao.update(author);
        return author.toString();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        Book author = authorDao.findById(id);
        authorDao.delete(author);
        return author.toString();
    }
}
