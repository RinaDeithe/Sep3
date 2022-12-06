package grpc.adapter.ItemType;

import GRPC.proto.File.*;
import database.daoInterfaces.IItemTypeDao;
import domain.Model.ItemType;

import static grpc.converter.itemTypeProto.ConverterItemType.itemType_To_ItemTypeProto;

public class ReadItemTypeAdapterDB
{
  private IItemTypeDao iItemTypeDao;

  public ReadItemTypeAdapterDB(IItemTypeDao iItemTypeDao)
  {
    this.iItemTypeDao = iItemTypeDao;
  }



  public ItemTypeProto readItemType(ItemTypeSearchRequest itemTypeSRProto)
  {
    ItemType itemType = null; //iItemTypeDao.Read(itemTypeSRProto.getId());


    return itemType_To_ItemTypeProto(itemType);
  }
}
