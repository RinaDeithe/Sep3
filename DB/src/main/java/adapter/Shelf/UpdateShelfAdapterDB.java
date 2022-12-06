package adapter.Shelf;

import Domain.Model.Item;
import Domain.Model.ItemType;
import Domain.Model.Shelf;
import Domain.Model.User;
import GRPC.proto.File.*;
import adapter.converter.ShelfProto.ConverterShelf;
import database.DaoInterface.IShelfDao;
import database.daoInterfaces.IShelfDao;
import domain.Model.Shelf;

public class UpdateShelfAdapterDB
{
  private IShelfDao iShelfDao;

  public UpdateShelfAdapterDB(IShelfDao iShelfDao)
  {
    this.iShelfDao = iShelfDao;
  }

  public ShelfProto shelfResponse(ShelfProto shelfProto)
  {
    Shelf shelf = ConverterShelf.shelfProto_To_shelf(shelfProto);
    shelf = iShelfDao.Update(shelf);

    return ConverterShelf.shelf_to_ShelfProto(shelf);
  }


}