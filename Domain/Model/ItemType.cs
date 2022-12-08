namespace Shared.Model; 

public class ItemType {

    public string Id { get; set; }
    public double DimX { get; set; }
    public double DimY { get; set; }
    public double DimZ { get; set; }

    public ItemType(string id, double dimX, double dimY, double dimZ)
    {
        Id = id;
        DimX = dimX;
        DimY = dimY;
        DimZ = dimZ;
    }
}