package database.daos;

import database.daoInterfaces.IDbDao;
import database.orm.DbConnection;

import java.util.List;

public class DbDao<T> implements IDbDao<T> {

    DbConnection<T> connection;

    public DbDao(DbConnection<T> connection) {
        this.connection = connection;
    }

    @Override
    public T Create(T entity) {
        connection.Create(entity);
        return entity;
    }

    @Override
    public T Read(T entity, int entityKey) {
        return connection.Read(entity, entityKey);
    }

    @Override
    public List<T> ReadAll(T entity) {
        return connection.ReadAll(entity);
    }

    @Override
    public T Update(T entity) {
        connection.Update(entity);
        return entity;
    }

    @Override
    public T Delete(T entity) {
        connection.Delete(entity);
        return entity;
    }
}
