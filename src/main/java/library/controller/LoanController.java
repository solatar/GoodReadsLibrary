package library.controller;

import java.time.LocalDate;
import library.entity.Book;
import library.entity.Loan;
import library.entity.User;
import library.repository.BookRepository;
import library.repository.LoanRepository;
import library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoanController {
    
    @Autowired
    LoanRepository loanRepo;
    
    @Autowired
    BookRepository bookRepo;
    
    @Autowired
    UserRepository userRepo;
    
    @Autowired
    LoanService loanService;
    
    @GetMapping("/borrow")
    public String showBorrowingForm(Model model) {
        model.addAttribute("loan", new Loan());
        model.addAttribute("localDate", LocalDate.now());
        return "borrow";
    }
   
    @PostMapping("/processBorrow")
    public String newLoan(@ModelAttribute Loan loan, Model model) {
        model.addAttribute("loan", loan);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        User current = userRepo.findByUsername(currentUser);
        loan.setUser(current);
        LocalDate due = LocalDate.now().plusMonths(1);
        loan.setDueDate(due);
        loanRepo.save(loan);
        int bookId = loan.getBook().getId();
        Book borrowed = bookRepo.getOne(bookId);
        borrowed.setStatus("unavailable");
        bookRepo.save(borrowed);
        return "confirmation";        
    }  

}
