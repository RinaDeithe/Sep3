package grpc.adapter.Item;

import GRPC.proto.File.*;
import grpc.converter.itemProto.ConverterItem;
import database.daoInterfaces.IItemDao;
import domain.Dto.ItemCreationDto;
import domain.Model.Item;

public class CreateItemAdapterDB {
    private IItemDao iItemDao;

    public CreateItemAdapterDB(IItemDao iItemDao)
    {
        this.iItemDao = iItemDao;
    }

    public ItemProto CreateItemProto(ItemCreation itemProto)
    {

        //ItemCreationDto item = ConverterItem.itemProtoCretion_to_Item(itemProto);

        //System.out.println("Im ready to create");
        Item result = null; // iItemDao.Create(item);


        return ConverterItem.item_To_ItemProto(result);
    }


}