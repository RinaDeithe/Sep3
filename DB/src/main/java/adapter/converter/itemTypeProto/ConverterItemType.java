package adapter.converter.itemTypeProto;

import Domain.Model.ItemType;
import GRPC.proto.File.*;

public class ConverterItemType
{
  public static ItemTypeProto itemType_To_ItemTypeProto(ItemType itemType)
  {
     return ItemTypeProto.newBuilder()
             .setId(itemType.getId())
             .setDimX(itemType.getDimX())
             .setDimY(itemType.getDimY())
             .setDimZ(itemType.getDimZ())
             .build();
  }



  public static ItemType itemTypeProto_To_ItemType(ItemTypeProto itemTypeProto)
  {
    return new ItemType(itemTypeProto.getId(),
        itemTypeProto.getDimX(),
        itemTypeProto.getDimY(),
        itemTypeProto.getDimZ());
  }

  public static ItemType itemTypeCreationProto_To_ItemType(ItemTypeCreationRequest itemTypeProto)
  {
    return new ItemType(itemTypeProto.getId(),
            itemTypeProto.getItemDimX(),
            itemTypeProto.getItemDimY(),
            itemTypeProto.getItemDimZ());
  }
}
