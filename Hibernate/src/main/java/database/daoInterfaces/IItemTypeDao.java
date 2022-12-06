package database.daoInterfaces;

import domain.Model.ItemType;

import java.util.List;

public interface IItemTypeDao {
    ItemType Create(ItemType type);
    ItemType Read(ItemType type, int id);
    List<ItemType> ReadAll(ItemType type);
    ItemType Update(ItemType type);
    ItemType Delete(ItemType type);
}
