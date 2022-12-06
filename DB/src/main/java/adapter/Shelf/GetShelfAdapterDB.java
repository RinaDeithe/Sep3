package adapter.Shelf;

import Domain.Model.Item;
import Domain.Model.Shelf;
import GRPC.proto.File.*;
import adapter.converter.ShelfProto.ConverterShelf;
import database.DaoInterface.IShelfDao;
import database.daoInterfaces.IShelfDao;
import domain.Model.Shelf;


public class GetShelfAdapterDB {

    private IShelfDao iShelfDao;

    public GetShelfAdapterDB(IShelfDao dao) {
        this.iShelfDao = dao;
    }

    public ShelfProto shelfResponse(ShelfSearchRequest shelfSRProto)
    {
        Shelf result = iShelfDao.Read(shelfSRProto.getId());

        return ConverterShelf.shelf_to_ShelfProto(result);

    }
}