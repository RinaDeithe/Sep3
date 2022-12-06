package database.daoInterfaces;

import domain.Dto.ItemCreationDto;
import domain.Model.Item;

public interface IItemDao {
    Item Create(ItemCreationDto item);
}
