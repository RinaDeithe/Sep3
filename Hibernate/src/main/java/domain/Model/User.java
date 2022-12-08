package domain.Model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;

    public User(int id) {
        this.id = id;
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
}
