package pl.coderslab.app.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.author.AuthorDao;
import pl.coderslab.app.publisher.PublisherDao;

@Controller
@RequestMapping("/view/book")
public class BookViewController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final PublisherDao publisherDao;

    public BookViewController(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/list")
    public String getListView(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "/books/list-view";
    }
}
