
package library.repository;

import java.util.List;
import library.entity.Loan;
import library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    @Query("SELECT l FROM Loan l WHERE l.user = ?1")
    public List findByUser(User user);
    
}
