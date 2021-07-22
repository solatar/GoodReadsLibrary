package library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import library.repository.LoanRepository;
import library.entity.Loan;

@SpringBootApplication
public class LibraryApplication {
    
    public static void main(String[] args) {
	SpringApplication.run(LibraryApplication.class, args);
    }
    


}
