using Shared.DTOs;
using Shared.Model;

namespace Logic.LogicInterfaces;

public interface IItemManager
{
    Task<itemType> CreateItemTypeAsync(ItemTypeCreationDto dto);

    Task<itemType> ReadItemTypeAsync(ItemTypeSearchDto dto);

}