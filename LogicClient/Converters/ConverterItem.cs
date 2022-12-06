using GRPC.Proto;
using Shared.DTOs.Item;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterItem
{
    public static Item ItemProtoToItem(ItemProto itemProto)
    {
        List<Item> items = new List<Item>();
        
        User user = ConverterUser.UserProtoToUser(itemProto.Owner);
            
        ItemType itemType = ConverterItemType.ItemTypeProtoToItemType(itemProto.Type);

        Shelf shelf = new Shelf();
        shelf.DimX = itemProto.Shelf.DimX;
        shelf.DimY = itemProto.Shelf.Dimz;
        shelf.DimZ = itemProto.Shelf.Dimz;
        shelf.RowNo = itemProto.Shelf.RowNo;
        shelf.ShelfNo = itemProto.Shelf.ShelfNo;


        Item result = new Item(itemType, itemProto.UniqueID, user, shelf);

        

        foreach (ItemProto item in itemProto.Shelf.ItemsOnShelf)
        {
            User _user = ConverterUser.UserProtoToUser(item.Owner);
            
            ItemType _itemType = ConverterItemType.ItemTypeProtoToItemType(item.Type);  
            
            items.Add(new Item(_itemType,itemProto.UniqueID,_user,shelf));
        }

        shelf.ItemsOnShelf = items;

        return result;
    }

    public static ItemCreation ItemCreationDtoToItemCreation(ItemCreationDto item)
    {
        return new ItemCreation
            { ItemTypeID = item.ItemTypeId, ShelfID = (int) item.shelfId!, OwnerID = item.OwnerId };
    }
}