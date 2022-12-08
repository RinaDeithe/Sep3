using Shared.DTOs;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace Logic.LogicInterfaces;

public interface IItemManager
{
    Task<ItemType> CreateItemTypeAsync(ItemTypeCreationDto dto);

    Task<ItemType> ReadItemTypeAsync(ItemTypeSearchDto dto);

}