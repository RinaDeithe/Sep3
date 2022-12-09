package domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ItemType implements Serializable
{

    @Id
    @Column(name = "ItemTypeId")
    private int id;

    @Column(name = "dimX")
    private Double dimX;

    @Column(name = "dimY")
    private Double dimY;
    @Column(name = "dimZ")
    private Double dimZ;

    public ItemType(int id, Double dimX, Double dimY, Double dimZ) {
        this.id = id;
        this.dimX = dimX;
        this.dimY = dimY;
        this.dimZ = dimZ;
    }

    public ItemType() {
        //DO NOT USE THIS CONSTRUCTOR
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getDimX() {
        return dimX;
    }

    public void setDimX(Double dimX) {
        this.dimX = dimX;
    }

    public Double getDimY() {
        return dimY;
    }

    public void setDimY(Double dimY) {
        this.dimY = dimY;
    }

    public Double getDimZ() {
        return dimZ;
    }

    public void setDimZ(Double dimZ) {
        this.dimZ = dimZ;
    }
}