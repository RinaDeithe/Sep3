package domain.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shelf implements Serializable {
    @Id
    @Column(name = "Id")
    private int Id;

    @Column(name = "RowNo")
    private String RowNo;

    @Column(name = "ShelfNo")
    private String ShelfNo;

    @Column(name = "dimX")
    private double dimX;

    @Column(name = "dimY")
    private double dimY;
    @Column(name = "dimZ")
    private double dimZ;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Item> itemsOnShelf;

    public Shelf(String rowNo, String shelfNo, double dimX, double dimY, double dimZ, List<Item> itemsOnShelf) {
        RowNo = rowNo;
        ShelfNo = shelfNo;
        Id = Integer.parseInt(RowNo + ShelfNo);
        this.dimX = dimX;
        this.dimY = dimY;
        this.dimZ = dimZ;
        this.itemsOnShelf = itemsOnShelf;
    }

    public Shelf() {
        //DO NOT USE THIS CONSTRUCTOR
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "RowNo='" + RowNo + '\'' +
                ", ShelfNo='" + ShelfNo + '\'' +
                ", dimX=" + dimX +
                ", dimY=" + dimY +
                ", dimZ=" + dimZ +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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
        return itemsOnShelf;
    }

    public void setItemsOnShelf(ArrayList<Item> itemsOnShelf) {
        this.itemsOnShelf = itemsOnShelf;
    }
}