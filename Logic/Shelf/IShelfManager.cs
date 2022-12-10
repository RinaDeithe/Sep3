using Shared.DTOs.Item;
using Shared.DTOs.Shelf;

namespace Logic.Shelf;

public interface IShelfManager
{
    Task<bool> Update(ShelfAddItemRequestDto dtos);

    Task<ItemRegisterRequestDto> GetAmountOnShelf(int ItemTypeId);

    Task<bool> HasRoom(ItemRegisterResponseDto dto);
    Task<List<Shared.Model.Shelf>> ReadAll();
}