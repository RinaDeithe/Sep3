package domain.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Item implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int UID;

    @ManyToOne
    private ItemType type;

    @ManyToOne
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

    @Override
    public String toString() {
        return "Item{" +
                "UID=" + UID +
                ", type=" + type +
                ", Owner=" + Owner +
                ", shelf=" + shelf +
                '}';
    }
}