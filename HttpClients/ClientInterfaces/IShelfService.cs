using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.DTOs.Shelf;
using Shared.Model;

namespace HttpClients.ClientInterfaces;

public interface IShelfService
{
    Task<bool> AddItemToShelf(List<ShelfAddItemRequestDto> dto);
    Task<List<Shelf>> getShelfs();
    Task<bool> HasRoom(ItemRegisterResponseDto dto);
    Task<ItemRegisterReqiestDto> GetAmountOnShelf(ItemTypeSearchDto dto);
}