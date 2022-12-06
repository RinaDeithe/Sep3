package adapter.Item;

import Domain.Dto.ItemCreateDto;
import Domain.Model.Item;
import GRPC.proto.File.*;
import adapter.converter.itemProto.ConverterItem;
import database.DaoInterface.IItemDao;
import database.daoInterfaces.IItemDao;
import domain.Dto.ItemCreateDto;
import domain.Model.Item;

public class CreateItemAdapterDB {
    private IItemDao iItemDao;

    public CreateItemAdapterDB(IItemDao iItemDao)
    {
        this.iItemDao = iItemDao;
    }

    public ItemProto CreateItemProto(ItemCreation itemProto)
    {
        ItemCreateDto item = ConverterItem.itemProtoCretion_to_Item(itemProto);

        System.out.println("Im ready to create");
        Item result = iItemDao.Create(item);


        return ConverterItem.item_To_ItemProto(result);
    }


}