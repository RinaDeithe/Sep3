using Shared.DTOs;
using Shared.DTOs.Shelf;

namespace Logic.Shelf;

public interface IShelfManager
{
    Task<bool> Update(List<ShelfAddItemRequestDto> dtos);

    Task<List<AmountOnSpaceDto>> GetAmountOnShelf(int ItemTypeId);

    Task<bool> HasRoom(int ItemTypeId);
}