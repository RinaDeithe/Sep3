using ClientgRPC.ClientInterfaces;
using ClientgRPC.StaticBusiness;
using Shared.DTOs;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.DTOs.Shelf;
using Shared.Model;

namespace Logic.Shelf;

public class ShelfManager : IShelfManager
{
    private readonly IShelfClient _shelfClient;
    private readonly IItemTypeClient _itemTypeClient;
    private IItemClient _itemClient;

    public ShelfManager(IShelfClient shelfClient, IItemTypeClient itemTypeClient, IItemClient itemClient)
    {
        _shelfClient = shelfClient;
        _itemTypeClient = itemTypeClient;
        _itemClient = itemClient;
    }

    public ShelfManager()
    {
    }

    public async Task<bool> Update(ShelfAddItemRequestDto dtos)
    {
        
        if (!await HasRoom(dtos))
        {
            return false;
        }
        
 
        
        

        foreach(AmountOnSpaceDto antalPåHylde in dtos.ShelfInfo)
        {
            
            
            for (int i = 0; i < antalPåHylde.AvalibleSpace; i++)
            {
                ItemCreationDto newItem = new ItemCreationDto(dtos.ItemTypeId, 1, dtos.Owner.Id
                    , false, antalPåHylde.ShelfId);
                _itemClient.Create(newItem);
            }
            
        }
        

        return true;
    }

    public async Task<ItemRegisterReqiestDto> GetAmountOnShelf(int itemTypeId)
    {
        List<AmountOnSpaceDto> result = new List<AmountOnSpaceDto>();

        

        ItemType _itemType = _itemTypeClient.Read(new ItemTypeSearchDto(itemTypeId)).Result;

        List < Shared.Model.Shelf > allShelves= await _shelfClient.ReadAll();
        foreach (var shelf in allShelves)
        {
            result.Add(Amount.AmountOnSpaceDto(shelf, _itemType));
        }

        ItemRegisterReqiestDto itemRegisterReqiestDto = new ItemRegisterReqiestDto(itemTypeId, result);

        return itemRegisterReqiestDto;
    }

    public Task<bool> HasRoom(int ItemTypeId)
    {
        throw new NotImplementedException();
    }

    public async Task<bool> HasRoom(ShelfAddItemRequestDto dtos)
    {
        ItemRegisterReqiestDto list = await GetAmountOnShelf(dtos.ItemTypeId);
        foreach (AmountOnSpaceDto spaces in list.ShelfInfo)
        {
            foreach (AmountOnSpaceDto places in dtos.ShelfInfo)
            {
                if (spaces.ShelfId.Equals(places.ShelfId))
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