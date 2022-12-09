using ClientgRPC.ClientInterfaces;
using Shared.DTOs.ItemType;

namespace Logic.AdapterToGRPC.ItemType;

public class ItemTypeMainAdapter: IItemTypeClient
{
    public Task<Shared.Model.ItemType> Create(ItemTypeCreationDto dto)
    {
        throw new NotImplementedException();
    }

    public Task<Shared.Model.ItemType> Read(ItemTypeSearchDto dto)
    {
        throw new NotImplementedException();
    }

    public Task<List<Shared.Model.ItemType>> ReadAll()
    {
        throw new NotImplementedException();
    }

    public Task<Shared.Model.ItemType> Update(Shared.Model.ItemType entity)
    {
        throw new NotImplementedException();
    }

    public Task<Shared.Model.ItemType> Delete(ItemTypeSearchDto dto)
    {
        throw new NotImplementedException();
    }
}