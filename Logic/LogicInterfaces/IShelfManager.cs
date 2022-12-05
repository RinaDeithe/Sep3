using Shared.DTOs;
using Shared.Model;

namespace Logic.LogicInterfaces;

public interface IShelfManager
{
    Task<bool> Update(List<ShelfAddItemRequestDto> dtos);

    Task<List<AmountOnSpaceDto>> GetAmountOnShelf(int ItemTypeId);

    Task<bool> HasRoom(int ItemTypeId);
}