package database.daoInterfaces;

import domain.Dto.ShelfCreationDto;
import domain.Model.Shelf;

public interface IItemTypeDao {

    Shelf Create(ShelfCreationDto dto);

}
