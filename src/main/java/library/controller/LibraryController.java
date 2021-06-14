package library.controller;

import java.util.List;
import library.entity.User;
import library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.BookService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {

    @Autowired
    BookService bookService;
    
    @Autowired
    UserRepository userRepo;

    @GetMapping("/showBooks")
    public String findBooks(Model model) {
        List books = bookService.findAll();
        for (int i=0; i<books.size(); i++) {
            System.out.println(books.get(i));
        }
        model.addAttribute("books", books);
        return "showBooks";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/processRegister")
    public String processRegister(User user) {        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "registerSuccess";
    }   
    
    @GetMapping("/loginPage")
    public String showLogin() {
        return "loginPage";
    }
       
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
    return "users";
    }
}
