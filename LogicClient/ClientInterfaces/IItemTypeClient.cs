using Shared.DTOs.ItemType;
using Shared.Model;

namespace LogicClient.ClientInterfaces;

public interface IItemTypeClient
{
    Task<ItemType> Create(ItemTypeCreationDto dto);
    Task<ItemType> Read(ItemTypeSearchDto dto);
    Task<List<ItemType>> ReadAll();
    Task<ItemType> Update(ItemType entity);
    Task<ItemType> Delete(ItemTypeSearchDto dto);

}