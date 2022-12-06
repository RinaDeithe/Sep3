using Shared.DTOs;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace HttpClients.ClientInterfaces;

public interface IItemTypeService
{
    Task<ItemType> CreateAsync(ItemTypeCreationDto dto);
    Task<ItemType> ReadAsync(int id);
}