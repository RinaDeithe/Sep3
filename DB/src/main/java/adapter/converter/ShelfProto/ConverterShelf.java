package adapter.converter.ShelfProto;

import Domain.Model.Item;
import Domain.Model.ItemType;
import Domain.Model.Shelf;
import Domain.Model.User;
import GRPC.proto.File.*;
import adapter.converter.itemTypeProto.ConverterItemType;
import adapter.converter.userProto.ConverterUser;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;

import java.util.ArrayList;

public class ConverterShelf
{

  public static ShelfProto shelf_to_ShelfProto(Shelf shelf)
  {
    ArrayList<ItemProto> itemProtos = new ArrayList<>();

    for (Item item : shelf.getItemsOnShelf())
    {
      itemProtos.add(ItemProto.newBuilder()
          .setType(ConverterItemType.itemType_To_ItemTypeProto(item.getType()))
          .setUniqueID(item.getUid())
          .setOwner(ConverterUser.User_To_UserProto(item.getOwner()))
          .build());


    }
    ShelfProto result=ShelfProto.newBuilder()
            .setRowNo(shelf.getRowNo())
            .setShelfNo(shelf.getShelfNo())
            .setShelfDimX(shelf.getDimX())
            .setShelfDimY(shelf.getDimY())
            .setShelfDimZ(shelf.getDimZ())
            .build();


    return result;
  }



  public static Shelf shelfProto_To_shelf(ShelfProto shelfproto)
  {
    ArrayList<Item> items = new ArrayList<>();

    Shelf shelf = new Shelf(shelfproto.getRowNo(),
        shelfproto.getShelfNo(),
        shelfproto.getShelfDimX(),
        shelfproto.getShelfDimY(),
        shelfproto.getShelfDimZ(),
        items);

    for (ItemProto item : shelfproto.getItemsOnShelfList())
    {
      ItemType itemType = ConverterItemType.itemTypeProto_To_ItemType(item.getType());
      User user = ConverterUser.UserProto_To_User(item.getOwner());

      items.add(new Item(itemType, item.getUniqueID(),user, shelf));
    }
    return shelf;
  }

}
