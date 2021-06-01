package library.controller;

import java.util.List;
import library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.BookService;

@Controller
public class LibraryController {

    @Autowired
    BookService bookService;

    @GetMapping("/showBooks")
    public String findBooks(Model model) {
        List books = bookService.findAll();
        model.addAttribute("books", books);
        return "showBooks";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}
