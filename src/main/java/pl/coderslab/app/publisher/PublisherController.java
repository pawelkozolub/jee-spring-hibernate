package pl.coderslab.app.publisher;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/get")
    public String get(@RequestParam Long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @PostMapping("/create")
    public String create(@RequestParam String name) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDao.save(publisher);
        return publisher.toString();
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return publisher.toString();
    }
}
