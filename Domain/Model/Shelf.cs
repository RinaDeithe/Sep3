namespace Shared.Model; 

public class Shelf {
    public Shelf(string? rowNo, string? shelfNo, double dimX, double dimY, double dimZ, List<Item>? itemsOnShelf) {
        RowNo = rowNo;
        ShelfNo = shelfNo;
        DimX = dimX;
        DimY = dimY;
        DimZ = dimZ;
        ItemsOnShelf = itemsOnShelf;
    }

    public string? RowNo { get; set; }
    public string? ShelfNo { get; set; }
    public double DimX { get; set; }
    public double DimY { get; set; }
    public double DimZ { get; set; }
    public List<Item>? ItemsOnShelf { get; set; }
    
}