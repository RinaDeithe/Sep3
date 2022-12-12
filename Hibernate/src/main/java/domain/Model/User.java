package domain.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @Column()
    private int id;

    @Column()
    private String role;

    public User(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public User() {
        //DO NOT USE THIS CONSTRUCTOR
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String something){
        role = something;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
