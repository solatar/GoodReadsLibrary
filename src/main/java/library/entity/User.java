package library.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String password;
    private int type;

    public User() {
        
    }
    
    public User(String name, String password, int role) {
        this.name = name;
        this.password = password;
        this.type = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        String userType;
        if (this.type == 2) {
            userType = "librarian";
        } else {
            userType = "customer";
        }
        return "User: " + this.name + ", role: " + userType;
    }        
}
