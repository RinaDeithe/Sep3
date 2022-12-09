package database.daoInterfaces;

import domain.Model.Item;

import java.util.List;

public interface IDbDao<T> {
    T Create(T entity);
    T Read(T classObject, String entity);
    List<T> ReadAll(T entity);
    T Update(T entity);
    T Delete(T entity);
}
