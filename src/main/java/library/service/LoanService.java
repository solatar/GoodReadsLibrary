package library.service;

import library.entity.Loan;
import library.repository.LoanRepository;
import java.util.List;
import library.entity.Book;        
import library.entity.User;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService  {

    @Autowired
    LoanRepository loanRepo;
    
    @Autowired
    BookRepository bookRepo;
    
    public List<Loan> findAll() {
       var allLoans = (List<Loan>) loanRepo.findAll();       
       return allLoans;        
    }

    public List<Loan> findByUser(User user) {
       var usersLoans = (List<Loan>) loanRepo.findByUser(user);
       return usersLoans;
    }   
    
    public int findBookId(int loanId) {
        Loan loan = loanRepo.getOne(loanId);
        int bookId = loan.getBook().getId();
        return bookId;
    }          
}
