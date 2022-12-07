package domain.Model;

import javax.persistence.*;

@Entity
public class Item {

    @OneToOne
    private ItemType type;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int UID;

    @OneToOne
    private User Owner;

    @ManyToOne
    private Shelf shelf;


    public Item(int UID, ItemType type, User owner, Shelf shelf) {
        this.type = type;
        this.UID = UID;
        Owner = owner;
        this.shelf = shelf;
    }

    public Item(ItemType type, User owner, Shelf shelf) {
        this.type = type;
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