package grpc.adapter.ItemType;

import GRPC.proto.File;
import grpc.converter.itemTypeProto.ConverterItemType;
import database.daoInterfaces.IItemTypeDao;
import domain.Model.ItemType;

public class CreateItemTypeAdapterDB {
    private IItemTypeDao dao;

    public CreateItemTypeAdapterDB(IItemTypeDao iItemTypeDao) {
        this.dao = iItemTypeDao;
    }


    public File.ItemTypeProto CreateItemType(File.ItemTypeCreationRequest itemTypProto){

        ItemType typeOfItem = ConverterItemType.itemTypeCreationProto_To_ItemType(itemTypProto);

        ItemType result = dao.Create(typeOfItem);

        return ConverterItemType.itemType_To_ItemTypeProto(result);
    }


}
