namespace Shared.Model; 

public class Shelf {

    public string? RowNo { get; set; }
    public string? ShelfNo { get; set; }
    public double DimX { get; set; }
    public double DimY { get; set; }
    public double DimZ { get; set; }
    public List<Item>? ItemsOnShelf { get; set; }
    
}