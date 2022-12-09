using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.DTOs.Shelf;
using Shared.Model;

namespace HttpClients.ClientInterfaces;

public interface IShelfService
{
    Task<bool> AddItemToShelf(ShelfAddItemRequestDto dto);
    Task<List<Shelf>> getShelfs();

    Task<ItemRegisterReqiestDto> GetAmountOnShelf(ItemTypeSearchDto dto);
}