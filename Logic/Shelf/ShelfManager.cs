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
                await _itemClient.Create(newItem);
            }
            
        }
        return true;
    }

    public async Task<ItemRegisterRequestDto> GetAmountOnShelf(int itemTypeId)
    {
        List<AmountOnSpaceDto> result = new List<AmountOnSpaceDto>();

        

        ItemType _itemType = _itemTypeClient.Read(new ItemTypeSearchDto(itemTypeId)).Result;

        List < Shared.Model.Shelf > allShelves= await _shelfClient.ReadAll();
        foreach (var shelf in allShelves)
        {
            
            result.Add(Amount.AmountOnSpaceDto(shelf, _itemType));
        }

        ItemRegisterRequestDto itemRegisterRequestDto = new ItemRegisterRequestDto(itemTypeId, result);

        return itemRegisterRequestDto;
    }

    public async Task<bool> HasRoom(ItemRegisterResponseDto dto)
    {
        List<Shared.Model.Shelf> shelfList = await ReadAll();
        int? totalItems = dto.Amount;
        double itemVoloume = Amount.ItemTypeMass(await _itemTypeClient.Read(new ItemTypeSearchDto(dto.ItemTypeId)));
        double totalAvailableSpace = 0;

        foreach (var index in shelfList)
        {
            double voloumeAvailable = Amount.ShelfMass(index);

            foreach (var itemIndex in index.ItemsOnShelf)
            {
                voloumeAvailable -= Amount.ItemTypeMass(itemIndex.Type);
            }

            totalAvailableSpace += voloumeAvailable;
        }

        if (!(itemVoloume * totalItems < totalAvailableSpace))
        {
            return false;
        }

        return true;
    }

    public async Task<List<Shared.Model.Shelf>> ReadAll()
    {
        return await _shelfClient.ReadAll();
    }


    public async Task<bool> HasRoom(ShelfAddItemRequestDto dtos)
    {
        ItemRegisterRequestDto list = await GetAmountOnShelf(dtos.ItemTypeId);
        foreach (AmountOnSpaceDto ShelfSpace in list.ShelfInfo)
        {
            foreach (AmountOnSpaceDto ItemSpace in dtos.ShelfInfo)
            {
                if (ShelfSpace.ShelfId.Equals(ItemSpace.ShelfId))
                {
                    if (ShelfSpace.AvalibleSpace<ItemSpace.AvalibleSpace)
                    {
                        throw new Exception("To many Item on shelf");
                    }
                }
            }
        }

        return true;
    }
}