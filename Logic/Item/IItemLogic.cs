using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace Logic.Item; 

public interface IItemLogic {
    Task<Shared.Model.Item> CreateAsync(ItemCreationDto dto);
    Task<ItemType> CreateItemTypeAsync(ItemTypeCreationDto dto);
    Task<ItemType> ReadItemTypeAsync(ItemTypeSearchDto dto);
    Task DeleteItemAsync(ItemSearchDto dto);
    Task<List<Shared.Model.Item>> ReadAllAsync();
    Task<ActionResult<bool>> CheckType(ItemTypeSearchDto dto);
}