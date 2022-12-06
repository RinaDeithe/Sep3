using ClientgRPC.ClientInterfaces;
using Logic.LogicInterfaces;
using Shared.DTOs;
using Shared.Model;

namespace Logic.Shelf;

public class ShelfManager : IShelfManager
{
    private IShelfClient _shelfClient;
    private IItemTypeClient _itemTypeClient;
    private IItemClient _itemClient;

    public ShelfManager(IShelfClient shelfClient, IItemTypeClient itemTypeClient, IItemClient itemClient)
    {
        _shelfClient = shelfClient;
        _itemTypeClient = itemTypeClient;
        _itemClient = itemClient;
    }

    public async Task<bool> Update(ShelfAddItemRequestDto dto)
    {
        throw new NotImplementedException();
    }

    public Task<bool> Update(List<ShelfAddItemRequestDto> dtos)
    {
        throw new NotImplementedException();
    }

    public async Task<List<AmountOnSpaceDto>> GetAmountOnShelf(int itemTypeId)
    {
        List<AmountOnSpaceDto> result = new List<AmountOnSpaceDto>();

        

        ItemType _itemType = _itemTypeClient.Read(new ItemTypeSearchDto(itemTypeId)).Result;

        List < Shared.Model.Shelf > allShelves= await _shelfClient.GetAllShelves();
        foreach (var shelf in allShelves)
        {
            throw new NotImplementedException();
            //result.Add(Amount.AmountOnSpaceDto(shelf, _itemType));
        }

        return result;
    }

    public Task<bool> HasRoom(int ItemTypeId)
    {
        throw new NotImplementedException();
    }

    public async Task<bool> HasRoom(ShelfAddItemRequestDto dtos)
    {
        List<AmountOnSpaceDto> list = await GetAmountOnShelf(dtos.ItemTypeId);
        foreach (AmountOnSpaceDto spaces in list)
        {
            foreach (AmountOnSpaceDto places in dtos.ShelfInfo)
            {
                if (spaces.ShelfID.Equals(places.ShelfID))
                {
                    if (spaces.AvalibleSpace<places.AvalibleSpace)
                    {
                        throw new Exception("To many Item on shelf");
                    }
                }
            }
        }

        return true;
    }
}