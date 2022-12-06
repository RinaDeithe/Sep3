package grpc.adapter.Shelf;

import GRPC.proto.File.*;
import grpc.converter.ShelfProto.ConverterShelf;
import database.daoInterfaces.IShelfDao;
import domain.Model.Shelf;


public class GetShelfAdapterDB {

    private IShelfDao iShelfDao;

    public GetShelfAdapterDB(IShelfDao dao) {
        this.iShelfDao = dao;
    }

    /*
    public ShelfProto shelfResponse(ShelfSearchRequest shelfSRProto)
    {
        Shelf result = iShelfDao.Read(shelfSRProto.getId());

        return ConverterShelf.shelf_to_ShelfProto(result);

    }

     */
}