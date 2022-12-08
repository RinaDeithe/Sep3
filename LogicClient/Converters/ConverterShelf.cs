using GRPC.Proto;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterShelf
{
    public static Shelf ShelfProtoToShelf(ShelfProto shelfProto){
        
    Shelf shelf = new Shelf();
    shelf.DimX = shelfProto.DimX;
    shelf.DimY = shelfProto.Dimy;
    shelf.DimZ = shelfProto.Dimz;
    shelf.RowNo = shelfProto.RowNo;
    shelf.ShelfNo = shelfProto.ShelfNo;
            
    shelf.ItemsOnShelf = new List<Item>();
    foreach (var items in shelfProto.ItemsOnShelf)
    {

        User userit = ConverterUser.UserProtoToUser(items.Owner);

        ItemType itemType = new ItemType(items.Type.Id, items.Type.DimX, items.Type.DimY, items.Type.DimZ);
                
        Item item = new Item(itemType, items.UniqueID, userit, shelf);
        shelf.ItemsOnShelf.Add(item);
    }

    return shelf;
    }

    public static ShelfProto ShelfToShelfProto(Shelf shelf)
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
    public static List<Shelf> AllShelvesProtoToAllShelves(ShelfListProtoReturn shelfProtos)
    {
        List<Shared.Model.Shelf> shelves = new List<Shared.Model.Shelf>();
        
        foreach (ShelfProto protoList in shelfProtos.ShelfListproto)
        {
            shelves.Add(ShelfProtoToShelf(protoList));
        }

        return shelves;
    }
}