using System.Collections;
using GRPC.Proto;
using Shared.DTOs;
using Shared.Model;

namespace Logic.AdapterToGRPC;

public class ConverterItem
{
    public static Shared.Model.Item ItemProtoToItem(ItemProto itemProto)
    {
        List<Shared.Model.Item> items = new List<Shared.Model.Item>();
        
        User user = ConverterUser.UserProtoToUser(itemProto.Owner);
            
        itemType itemType = ConverterItemType.ItemTypeProtoToItemType(itemProto.Type);

        Shared.Model.Shelf shelf = new Shared.Model.Shelf();
        shelf.DimX = itemProto.Shelf.DimX;
        shelf.DimY = itemProto.Shelf.Dimz;
        shelf.DimZ = itemProto.Shelf.Dimz;
        shelf.RowNo = itemProto.Shelf.RowNo;
        shelf.ShelfNo = itemProto.Shelf.ShelfNo;


        Shared.Model.Item result = new Shared.Model.Item(itemType, itemProto.UniqueID, user, shelf);

        

        foreach (ItemProto item in itemProto.Shelf.ItemsOnShelf)
        {
            User _user = ConverterUser.UserProtoToUser(item.Owner);
            
            itemType _itemType = ConverterItemType.ItemTypeProtoToItemType(item.Type);  
            
            items.Add(new Shared.Model.Item(_itemType,itemProto.UniqueID,_user,shelf));
        }

        shelf.ItemsOnShelf = items;

        return result;
    }

    public static ItemCreation ItemCreationDtoToItemCreation(ItemCreationDto item)
    {
        return new GRPC.Proto.ItemCreation
            { ItemTypeID = item.ItemTypeId, ShelfID = item.shelfId, OwnerID = item.OwnerId };
    }
}