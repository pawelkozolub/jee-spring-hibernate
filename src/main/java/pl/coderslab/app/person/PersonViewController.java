package pl.coderslab.app.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view/person")
public class PersonViewController {

    private final PersonDao personDao;

    public PersonViewController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/old-way")
    public String getViewOldWay() {
        // request.getRequestDispatcher("person-old.jsp").forward(request, response);   // as in servlets
        return "person-old";
    }

    @PostMapping("/old-way")
    public String createPersonOldWay(@RequestParam String login,
                                     @RequestParam String email,
                                     @RequestParam String password) {
        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        personDao.save(person);
        // response.sendRedirect(request.getContextPath + "/view/person/old-way");      // as in servlets
        return "redirect:/view/person/old-way";
    }

    @GetMapping("/new-way")
    public String getViewNewWay(Model model) {
        model.addAttribute("person", new Person());
        return "person-new";
    }

    @PostMapping("/new-way")
    public String createPersonNewWay(Person person) {
        personDao.save(person);
        return "redirect:/view/person/new-way";
    }
}
