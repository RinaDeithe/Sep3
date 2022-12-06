package database.daos;

import database.daoInterfaces.IShelfDao;
import database.orm.DbConnection;
import domain.Model.Item;
import domain.Model.Shelf;

import java.util.List;

public class ShelfDao implements IShelfDao {

    private final DbConnection<Shelf> connection;

    public ShelfDao(DbConnection<Shelf> connection) {
        this.connection = connection;
    }

    @Override
    public Shelf Create(Shelf shelf) {
        connection.create(shelf);
        return shelf;
    }

    @Override
    public Shelf Read(Shelf shelf, int entityKey) {
        return connection.read(shelf, entityKey);
    }

    @Override
    public List<Shelf> ReadAll(Shelf shelf) {
        return connection.readAll(shelf);
    }

    @Override
    public Shelf Update(Shelf shelf) {
        connection.update(shelf);
        return shelf;
    }

    @Override
    public Shelf Delete(Shelf shelf) {
        connection.delete(shelf);
        return shelf;
    }
}
