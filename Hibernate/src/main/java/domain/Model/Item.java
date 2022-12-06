package domain.Model;

import javax.persistence.*;

@Entity
public class Item {

    @Column
    @OneToOne
    private ItemType type;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int UID;

    @Column(name = "name")
    @OneToOne
    private User Owner;

    @OneToOne
    @Column(name = "shelf")
    private Shelf shelf;


    public Item(ItemType type, int UID, User owner, Shelf shelf) {
        this.type = type;
        this.UID = UID;
        Owner = owner;
        this.shelf = shelf;
    }

    public Item() {
        //DO NOT USE THIS CONSTRUCTOR
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
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