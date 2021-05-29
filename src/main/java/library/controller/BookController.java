package library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/showBooks")
    public String findCities(Model model) {
        return "showBooks";
    }
}
