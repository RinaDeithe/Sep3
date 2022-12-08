package domain.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "role")
    private String role;

    public User(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public User() {
        //DO NOT USE THIS CONSTRUCTOR
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String something){
        role = something;
    }
}
