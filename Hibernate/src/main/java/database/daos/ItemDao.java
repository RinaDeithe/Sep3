package database.daos;

import database.daoInterfaces.IItemDao;
import database.orm.DbConnection;
import domain.Model.Item;

import java.util.List;

public class ItemDao implements IItemDao {

    private DbConnection<Item> connection;

    public ItemDao(DbConnection<Item> connection) {
        this.connection = connection;
    }

    @Override
    public Item Create(Item item) {
        connection.create(item);
        return item;
    }

    @Override
    public Item Read(Item item, int entityKey) {
        return connection.read(item, entityKey);
    }

    @Override
    public List<Item> ReadAll(Item item) {
        return connection.readAll(item);
    }

    @Override
    public Item Update(Item item) {
        connection.update(item);
        return item;
    }

    @Override
    public Item Delete(Item item) {
        connection.delete(item);
        return item;
    }
}
