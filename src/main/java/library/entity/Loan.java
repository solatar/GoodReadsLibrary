package library.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "loans")
public class Loan implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
    private User user;
    
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;       
    
       
    public Loan() {
    }

    public Loan(Book book, User user, LocalDate dueDate) {
        this.book = book;
        this.user = user;
        this.dueDate = dueDate;
    }
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }  

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }       

    @Override
    public String toString() {
        return this.book + ", borrowed by: " + this.user + " due date: " + this.dueDate;
    }   
}
