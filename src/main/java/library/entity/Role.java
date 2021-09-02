package library.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="description")
    private String description;

    public Role() {
        
    }
    
    public Role(String description) {
        this.description = description;
    }   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role possessed: " +this.description;
    }    
}
