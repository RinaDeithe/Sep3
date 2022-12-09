using Shared.DTOs;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace HttpClients.ClientInterfaces;

public interface IItemTypeService
{
    Task<ItemType> CreateAsync(ItemTypeCreationDto dto);
    Task<ItemType> ReadAsync(ItemTypeSearchDto dto);
    
    Task<bool> CheckType(ItemTypeSearchDto dto);
    
    Task<ItemType> CreateType(ItemTypeCreationDto dto);
    
    Task<bool> CheckType();
}