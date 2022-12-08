using Shared.DTOs;
using Shared.Model;

namespace ClientgRPC.StaticBusiness;

public class Amount
{
    public static AmountOnSpaceDto AmountOnSpaceDto(Shelf shelf, ItemType itemType)
    {
        double volumenShelf = shelf.DimX * shelf.DimY * shelf.DimZ;
        double volumenItemType = itemType.DimX * itemType.DimY * itemType.DimZ;

        return new AmountOnSpaceDto(shelf.RowNo+shelf.ShelfNo,(int?)Math.Floor(volumenShelf / volumenItemType));
    }
}