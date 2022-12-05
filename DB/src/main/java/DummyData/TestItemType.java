package DummyData;


import Domain.Model.ItemType;
import database.DaoInterface.IItemTypeDao;

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
