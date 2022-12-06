package adapter.ItemType;

import Domain.Model.ItemType;
import GRPC.proto.File.*;
import database.DaoInterface.IItemTypeDao;
import database.daoInterfaces.IItemTypeDao;
import domain.Model.ItemType;

import static adapter.converter.itemTypeProto.ConverterItemType.itemType_To_ItemTypeProto;

public class ReadItemTypeAdapterDB
{
  private IItemTypeDao iItemTypeDao;

  public ReadItemTypeAdapterDB(IItemTypeDao iItemTypeDao)
  {
    this.iItemTypeDao = iItemTypeDao;
  }



  public ItemTypeProto readItemType(ItemTypeSearchRequest itemTypeSRProto)
  {
    ItemType itemType = iItemTypeDao.Read(itemTypeSRProto.getId());


    return itemType_To_ItemTypeProto(itemType);
  }
}
