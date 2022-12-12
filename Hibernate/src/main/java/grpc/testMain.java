package grpc;

import GRPC.proto.File;
import database.daoInterfaces.IDbDao;
import database.orm.DbConnection;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;
import grpc.converter.ItemConverter;
import grpc.services.GrpcItemService;

import java.util.ArrayList;

public class testMain {
    public static void main(String[] args) {
        IDbDao<Item> ItemDao = new DbConnection<>();
        IDbDao<User> UserDao = new DbConnection<>();
        IDbDao<ItemType> TypeDao = new DbConnection<>();
        IDbDao<Shelf> ShelfDao = new DbConnection<>();

        User user = new User(0, "test");

        ItemType type = new ItemType(-1, -1.0, -1.0, -1.0);
        Shelf shelf = new Shelf("test", "shelf", -1.0, -1.0, -1.0, new ArrayList<>());
/*
        UserDao.Create(user);

        TypeDao.Create(type);

        ShelfDao.Create(shelf);
*/

        Item olditem = new Item(type, user, shelf);

        Item item = ItemDao.Create(olditem);

        GrpcItemService safe = new GrpcItemService(ItemDao);

        File.ItemCreation itemCreationProto =  File.ItemCreation.newBuilder().setItemTypeID(-1).setOwnerID(-1).setShelfID("-1").build();



        Item newItem = ItemConverter.CONVERT.toItemFromCreation(itemCreationProto);

        System.out.println("OldTest = " + olditem);
        System.out.println("test =" + newItem);


        newItem = ItemDao.Create(newItem);

        File.ItemProto proto = ItemConverter.CONVERT.toItemProtoFromItem(newItem);


        System.out.println(proto);
    }
}
