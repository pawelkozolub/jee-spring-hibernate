package pl.coderslab.app.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @ModelAttribute("countries")
    public List<String> countries() {
        return List.of("Poland", "Germany", "Czech Republic");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return List.of("Fishing", "Swimming", "Walking");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return List.of("Java", "HTML", "php");
    }

    @GetMapping("/create")
    public String getView(Model model) {
        model.addAttribute("student", new Student());
        return "create-student";
    }

    @PostMapping("/create")
    public String createStudent(Student student) {
        logger.info("STUDENT SAVED: {}", student);
        return "create-student-success";
    }
}
