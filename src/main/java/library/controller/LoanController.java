package library.controller;

import java.time.LocalDate;
import java.util.List;
import library.entity.Book;
import library.entity.Loan;
import library.entity.User;
import library.repository.BookRepository;
import library.repository.LoanRepository;
import library.repository.UserRepository;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    @Autowired
    BookService bookService;
    
    @GetMapping("/showBooks")
    public String findBooks(Model model) {
        List books = bookService.findAll();
        model.addAttribute("books", books);
        return "showBooks";
    }
    
    @GetMapping("/borrow/{id}")
    public String showBorrowingForm(@PathVariable("id") int id, Model model) {
        Book book = bookRepo.getOne(id);
        model.addAttribute("book", book);
        model.addAttribute("loan", new Loan());
        model.addAttribute("localDate", LocalDate.now());
        return "borrow";
    }    
   
    @PostMapping("/processBorrow/{id}")
    public String newLoan(@PathVariable("id") int id, @ModelAttribute Loan loan, Model model) {
        model.addAttribute("loan", loan);
        Book book = bookRepo.getOne(id);
        loan.setBook(book);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        User current = userRepo.findByUsername(currentUser);
        loan.setUser(current);
        LocalDate due = LocalDate.now().plusMonths(1);
        loan.setDueDate(due);
        loanRepo.save(loan);
        book.setStatus("unavailable");
        bookRepo.save(book);
        return "redirect:/confirmation";
    } 
    
    @GetMapping("showLoans")
    public String listAllLoans(Model model) {
        List<Loan> allLoans = loanService.findAll();
        model.addAttribute("allLoans", allLoans);        
        return "showLoans";
    }
    
    @GetMapping("/return/{id}")
    public String returnConfirmation(@PathVariable("id") int id, Model model) {
        Loan loan = loanRepo.getOne(id);
        model.addAttribute("loan", loan);
        return "return";
    }
    
    @PostMapping("/returnLoan/{id}")
    public String updateLoan(@PathVariable("id") int id, Model model) {
        Loan loan = loanRepo.getOne(id);
        int bookId = loanService.findBookId(id);
        Book book = bookRepo.getOne(bookId);
        System.out.println("BookId: " +book.getId());
        book.setStatus("available");
        loanRepo.deleteById(id);
        bookRepo.save(book);
        return "redirect:/ownPage";          
    }
}
