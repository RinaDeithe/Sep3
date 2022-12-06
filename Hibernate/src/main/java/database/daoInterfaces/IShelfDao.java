package database.daoInterfaces;

import domain.Model.Shelf;

import java.util.List;

public interface IShelfDao {
    Shelf Create(Shelf shelf);
    Shelf Read(Shelf shelf, int id);
    List<Shelf> ReadAll(Shelf shelf);
    Shelf Update(Shelf shelf);
    Shelf Delete(Shelf shelf);
}
