package database.DummyData;

import database.daoInterfaces.IItemTypeDao;
import domain.Model.ItemType;

public class TestItemType implements IItemTypeDao {

    @Override
    public ItemType Create(ItemType dto) {
        return new ItemType(dto.getId(), dto.getDimX(), dto.getDimY(), dto.getDimZ());
    }

    @Override
    public ItemType Read(int dto) {
        return new ItemType(1,2.,3.,4.);
    }

    @Override
    public ItemType Update(ItemType itemType) {
        return null;
    }
}