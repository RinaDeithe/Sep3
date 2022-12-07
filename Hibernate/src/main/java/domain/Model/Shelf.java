package domain.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shelf implements Serializable {
    @Id
    @Column(name = "RowNo")
    private String RowNo;

    @Id
    @Column(name = "ShelfNo")
    private String ShelfNo;

    @Column(name = "dimX")
    private double dimX;

    @Column(name = "dimY")
    private double dimY;
    @Column(name = "dimZ")
    private double dimZ;

    @ManyToMany
    private List<Item> ItemsOnShelf;

    public Shelf(String rowNo, String shelfNo, double dimX, double dimY, double dimZ, ArrayList<Item> itemsOnShelf) {
        RowNo = rowNo;
        ShelfNo = shelfNo;
        this.dimX = dimX;
        this.dimY = dimY;
        this.dimZ = dimZ;
        ItemsOnShelf = itemsOnShelf;
    }

    public Shelf() {
        //DO NOT USE THIS CONSTRUCTOR
    }

    public String getRowNo() {
        return RowNo;
    }

    public void setRowNo(String rowNo) {
        RowNo = rowNo;
    }

    public String getShelfNo() {
        return ShelfNo;
    }

    public void setShelfNo(String shelfNo) {
        ShelfNo = shelfNo;
    }

    public double getDimX() {
        return dimX;
    }

    public void setDimX(double dimX) {
        this.dimX = dimX;
    }

    public double getDimY() {
        return dimY;
    }

    public void setDimY(double dimY) {
        this.dimY = dimY;
    }

    public double getDimZ() {
        return dimZ;
    }

    public void setDimZ(double dimZ) {
        this.dimZ = dimZ;
    }

    public List<Item> getItemsOnShelf() {
        return ItemsOnShelf;
    }

    public void setItemsOnShelf(ArrayList<Item> itemsOnShelf) {
        ItemsOnShelf = itemsOnShelf;
    }
}