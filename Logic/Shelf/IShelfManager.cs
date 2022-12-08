using Shared.DTOs.Item;
using Shared.DTOs.Shelf;

namespace Logic.Shelf;

public interface IShelfManager
{
    Task<bool> Update(ShelfAddItemRequestDto dtos);

    Task<ItemRegisterReqiestDto> GetAmountOnShelf(string ItemTypeId);

    Task<bool> HasRoom(ShelfAddItemRequestDto dtos);
}