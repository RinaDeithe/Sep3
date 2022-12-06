package adapter.converter.itemProto;

import Domain.Dto.ItemCreateDto;
import Domain.Model.Item;
import Domain.Model.ItemType;
import Domain.Model.Shelf;
import Domain.Model.User;
import GRPC.proto.File.*;
import adapter.converter.ShelfProto.ConverterShelf;
import adapter.converter.itemTypeProto.ConverterItemType;
import adapter.converter.userProto.ConverterUser;
import domain.Dto.ItemCreateDto;
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
        .setUniqueID(item.getUid())
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

  public static ItemCreateDto itemProtoCretion_to_Item(ItemCreation itemProto)
  {


    return new ItemCreateDto(
            itemProto.getItemTypeID(),
            itemProto.getOwnerID(),
            itemProto.getShelfID()
    );

  }
}





