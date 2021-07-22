package library.controller;

import java.util.List;
import java.util.Optional;
import library.entity.Loan;
import library.entity.User;
import library.repository.BookRepository;
import library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.BookService;
import library.service.LoanService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import library.entity.Role;
import library.entity.UserRole;
import library.repository.RoleRepository;
import library.repository.UserRoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
public class LibraryController {
  
    @Autowired
    BookService bookService;
    
    @Autowired
    LoanService loanService;
    
    @Autowired
    UserRepository userRepo;
    
    @Autowired
    BookRepository bookRepo;
    
    @Autowired
    RoleRepository roleRepo;
    
    @Autowired UserRoleRepository urRepo;

    @GetMapping("/index")
    public String showHmePage() {
        return "home";
    }
    
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
    
    @PostMapping("/processRegister")
    public String processRegister(User user) {     
        System.out.println(user.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role patron = roleRepo.getOne(1);
        user.getRoles().add(patron);
        UserRole ur = new UserRole(user, patron);
        userRepo.save(user);
        urRepo.save(ur);      
        return "registerSuccess";
    }   
    
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
       
    @GetMapping("/ownPage")
    public String listLoans(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        User current = userRepo.findByUsername(currentUser);
        List<Loan> loans = loanService.findByUser(current);
        model.addAttribute("loans", loans);
    return "ownPage";
    }
    
    @PostMapping("/login")
    public String defaultAfterLogin(HttpServletRequest request) {
        return "ownPage";
    }  
    

}
