using GRPC.Proto;
using Shared.Model;

namespace Logic.AdapterToGRPC;

public class ConverterShelf
{
    public static Shared.Model.Shelf ShelfProtoToShelf(ShelfProto shelfProto){
        
    Shared.Model.Shelf shelf = new Shared.Model.Shelf();
    shelf.DimX = shelfProto.DimX;
    shelf.DimY = shelfProto.Dimy;
    shelf.DimZ = shelfProto.Dimz;
    shelf.RowNo = shelfProto.RowNo;
    shelf.ShelfNo = shelfProto.ShelfNo;
            
    shelf.ItemsOnShelf = new List<Shared.Model.Item>();
    foreach (var itemss in shelfProto.ItemsOnShelf)
    {

        User userit = ConverterUser.UserProtoToUser(itemss.Owner);

        itemType _itemType = new itemType(itemss.Type.Id, itemss.Type.DimX, itemss.Type.DimY, itemss.Type.DimZ);
                
        Shared.Model.Item item = new Shared.Model.Item(_itemType, itemss.UniqueID, userit, shelf);
        shelf.ItemsOnShelf.Add(item);
    }

    return shelf;
    }

    public static ShelfProto ShelfToShelfProto(Shared.Model.Shelf shelf)
    {
        return new ShelfProto
        {
            Dimy = shelf.DimY, Dimz = shelf.DimZ, DimX = shelf.DimX, RowNo = shelf.RowNo, ShelfNo = shelf.ShelfNo
        };
    }
/*
    public static List<Shared.Model.Shelf> AllShelvesProtoToAllShelves(ShelvesListProto shelvesListProto)
    {
        List<Shared.Model.Shelf> result = new List<Shared.Model.Shelf>();
        
        foreach (ShelfProto protoList in shelvesListProto.Proto)
        {
            result.Add(ShelfProtoToShelf(protoList));
        }

        return result;
    }
    */
}