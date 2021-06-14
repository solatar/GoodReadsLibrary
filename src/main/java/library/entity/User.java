package library.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "username", nullable = false)
    private String username;
    
    @Column(name = "password", length = 125, nullable = false)
    private String password;
    
    @Column(name = "type", nullable = false)
    private int type;
    
    @OneToOne(mappedBy = "user")
    private Loan loan;
    
    public User() {
        
    }
    
    public User(String name, String password, int type) {
        this.username = name;
        this.password = password;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }    

    @Override
    public String toString() {
        String userType;
        if (this.type == 2) {
            userType = "librarian";
        } else {
            userType = "customer";
        }
        return "User: " + this.username + ", role: " + userType;
    }        
}
