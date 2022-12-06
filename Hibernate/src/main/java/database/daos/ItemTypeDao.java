package database.daos;

import database.daoInterfaces.IItemTypeDao;
import database.orm.DbConnection;
import domain.Model.Item;
import domain.Model.ItemType;

import java.util.List;

public class ItemTypeDao implements IItemTypeDao {

    private DbConnection<ItemType> connection;

    public ItemTypeDao(DbConnection<ItemType> connection) {
        this.connection = connection;
    }

    @Override
    public ItemType Create(ItemType type) {
        connection.create(type);
        return type;
    }

    @Override
    public ItemType Read(ItemType type, int entityKey) {
        return connection.read(type, entityKey);
    }

    @Override
    public List<ItemType> ReadAll(ItemType type) {
        return connection.readAll(type);
    }

    @Override
    public ItemType Update(ItemType type) {
        connection.update(type);
        return type;
    }

    @Override
    public ItemType Delete(ItemType type) {
        connection.delete(type);
        return type;
    }
}
