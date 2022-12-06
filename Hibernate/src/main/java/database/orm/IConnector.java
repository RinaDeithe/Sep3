package database.orm;

import java.util.List;

public interface IConnector<T> {

    void create(T entity);
    T read(T classObject, int entityKey);
    List<T> readAll(T classObject);
    void update(T entity);
    void delete(T entity);

}
