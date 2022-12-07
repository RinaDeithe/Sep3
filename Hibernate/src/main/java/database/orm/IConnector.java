package database.orm;

import java.util.List;

public interface IConnector<T> {

    void Create(T entity);
    T Read(T classObject, int entityKey);
    List<T> ReadAll(T classObject);
    void Update(T entity);
    void Delete(T entity);

}
