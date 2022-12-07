using Shared.DTOs;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace Logic.Item; 

public interface IItemLogic {
    Task<Shared.Model.Item> CreateAsync(ItemCreationDto dto);
    Task<ItemType> CreateItemTypeAsync(ItemTypeCreationDto dto);
    
    
}