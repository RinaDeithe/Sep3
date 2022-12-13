package UnitTest;

import GRPC.proto.File;
import database.daoInterfaces.IDbDao;
import database.orm.DbConnection;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;
import grpc.converter.ItemConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestAfItem {

    IDbDao<Item> ItemDao;
    IDbDao<User> UserDao;
    IDbDao<ItemType> TypeDao;
    IDbDao<Shelf> ShelfDao;

    @BeforeEach
    public void init(){
        ItemDao = new DbConnection<>();
        UserDao = new DbConnection<>();
        TypeDao = new DbConnection<>();
        ShelfDao = new DbConnection<>();
    }


    @Test
    public void ItemCreation(){


        User user = new User(0, "test");

        ItemType type = new ItemType(-1, -1.0, -1.0, -1.0);
        Shelf shelf = new Shelf("test", "shelf", -1.0, -1.0, -1.0, new ArrayList<>());

        UserDao.Create(user);

        TypeDao.Create(type);

        ShelfDao.Create(shelf);

        Item item = ItemDao.Create(new Item(type, user, shelf));

        if (item !=null){
            assert true;
        }


    }

    @Test
    public void GetItem(){
        Item item = ItemDao.Read(new Item(),-1);
        if (item.getUID()==-1 && item.getType().getId()==-1){
            assert true;
        }else {
            assert false;
        }
    }

    @Test
            public void CreateItemProto() {
        File.ItemCreation itemCreation = File.ItemCreation.newBuilder().setItemTypeID(1).setOwnerID(1).setShelfID("1").build();

        ItemType itemType = new ItemType(1, null, null, null);
        User user = new User(1, "temp");

        ArrayList<Item> items = new ArrayList<>();

        Shelf shelf = new Shelf(1 + "", 1 + "", 0.0, 0.0, 0.0, items);


        Item item = ItemConverter.CONVERT.toItemFromCreation(itemCreation);


        if (item.getType().toString().equals(itemType.toString())) {
            assert true;
        } else {
            System.out.println("itemType not the same");
            assert false;
        }
        if (item.getOwner().toString().equals(user.toString())) {
            assert true;
        } else {
            System.out.println("wrong user");
            assert false;
        }if (item.getShelf().toString().equals(shelf.toString())){
            assert true;
        }else {
            System.out.println("wrong shelf");
            assert false;
        }

    }
}
