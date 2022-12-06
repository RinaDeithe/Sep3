package database.daoInterfaces;

import domain.Model.Item;

import java.util.List;

public interface IItemDao {
    Item Create(Item item);
    Item Read(Item item, int id);
    List<Item> ReadAll(Item item);
    Item Update(Item item);
    Item Delete(Item item);
}
