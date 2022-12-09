using Shared.DTOs.Item;
using Shared.DTOs.Shelf;

namespace Logic.Shelf;

public interface IShelfManager
{
    Task<bool> Update(ShelfAddItemRequestDto dtos);

    Task<ItemRegisterReqiestDto> GetAmountOnShelf(int ItemTypeId);

    Task<bool> HasRoom(int ItemTypeId);
}