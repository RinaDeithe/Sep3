package grpc.converter.itemProto;

import GRPC.proto.File.*;
import grpc.converter.ShelfProto.ConverterShelf;
import grpc.converter.itemTypeProto.ConverterItemType;
import grpc.converter.userProto.ConverterUser;
import domain.Dto.ItemCreationDto;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;

public class ConverterItem
{
  public static ItemProto item_To_ItemProto(Item item)
  {
    return ItemProto.newBuilder()
        .setType(ConverterItemType.itemType_To_ItemTypeProto(item.getType()))
        .setUniqueID(item.getUID())
        .setOwner(ConverterUser.User_To_UserProto(item.getOwner()))
        .setShelf(ConverterShelf.shelf_to_ShelfProto(item.getShelf()))
        .build();
  }



  public static Item itemProto_to_Item(ItemProto itemProto)
  {
    ItemType itemType = ConverterItemType.itemTypeProto_To_ItemType(itemProto.getType());
    User user = ConverterUser.UserProto_To_User(itemProto.getOwner());
    Shelf shelf = ConverterShelf.shelfProto_To_shelf(itemProto.getShelf());


    return new Item(
        itemType,
        itemProto.getUniqueID(),
        user,
        shelf
    );

  }

  public static ItemCreationDto itemProtoCretion_to_Item(ItemCreation itemProto)
  {


    return new ItemCreationDto(
            itemProto.getItemTypeID(),
            itemProto.getOwnerID(),
            itemProto.getShelfID()
    );

  }
}





