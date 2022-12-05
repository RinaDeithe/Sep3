package Domain.Model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Item {

    @Column
    @OneToOne
    private ItemType type;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Uid;

    @Column(name = "name")
    @OneToOne
    private User Owner;

    @OneToOne
    @Column(name = "shelf")
    private Shelf shelf;


    public Item(ItemType type, int uid, User owner, Shelf shelf) {
        this.type = type;
        Uid = uid;
        Owner = owner;
        this.shelf = shelf;
    }

    public Item() {

    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public User getOwner() {
        return Owner;
    }

    public void setOwner(User owner) {
        Owner = owner;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}
