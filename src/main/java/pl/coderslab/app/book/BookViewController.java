package pl.coderslab.app.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.app.author.AuthorDao;
import pl.coderslab.app.publisher.PublisherDao;

import javax.validation.Valid;

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

    @GetMapping("/add")
    public String getAddView(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("publisherList", publisherDao.findAll());
        model.addAttribute("authorList", authorDao.findAll());
        return "/books/add-view";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // see MK comments:
            // Parametr Book book jest automatycznie umieszczany w modelu pod nazwą
            // "book", która wynika z nazwy klasy, a nie nazwy parametru.
            // Nie trzeba używać: model.addAttribute("book", book);
            //
            // Umieszczenie pod inną nazwą wymaga użycia @ModelAttribute, np.
            // @ModelAttribute("addedBook") Book book.
            model.addAttribute("publisherList", publisherDao.findAll());
            model.addAttribute("authorList", authorDao.findAll());
            return "/books/add-view";
        }
        bookDao.save(book);
        return "redirect:/view/book/list";
    }

    @GetMapping("/update")
    public String getUpdateView(Model model, @RequestParam long id) {
        model.addAttribute("book", bookDao.findById(id));
        model.addAttribute("publisherList", publisherDao.findAll());
        model.addAttribute("authorList", authorDao.findAll());
        return "/books/update-view";
    }

    @PostMapping("/update")
    public String updateBook(@Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // comments from above also apply here
            model.addAttribute("publisherList", publisherDao.findAll());
            model.addAttribute("authorList", authorDao.findAll());
            return "/books/update-view";
        }
        bookDao.update(book);
        return "redirect:/view/book/list";
    }
}
