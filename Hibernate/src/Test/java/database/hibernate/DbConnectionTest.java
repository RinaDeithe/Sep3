package database.hibernate;

import database.daoInterfaces.IDbDao;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;
import org.junit.jupiter.api.Test;

class DbConnectionTest {

    @Test
    void create() {

        IDbDao<Item> ItemDao = new DbConnection<>();
        IDbDao<User> UserDao = new DbConnection<>();
        IDbDao<ItemType> TypeDao = new DbConnection<>();
        IDbDao<Shelf> ShelfDao = new DbConnection<>();

        User user = new User("0", "test");

        ItemType type = new ItemType("-1", -1.0, -1.0, -1.0);
        Shelf shelf = new Shelf("test", "shelf", -1.0, -1.0, -1.0, null);

        UserDao.Create(user);

        TypeDao.Create(type);

        ShelfDao.Create(shelf);

        ItemDao.Create(new Item(type, user, shelf));
    }
}