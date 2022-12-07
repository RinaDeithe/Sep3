using LogicClient.ClientInterfaces;
using LogicClient.GRPC_stubs;
using Shared.DTOs;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace Logic.Item; 

public class ItemManager : IItemLogic
{
    IShelfClient _shelfClient;
    IItemClient _itemClient; 
    IItemTypeClient _itemTypeClient;
    
    public ItemManager()
    {
        _shelfClient = new ShelfStub();
        _itemTypeClient = new ItemTypeStub();
        _itemClient = new ItemStub();
    }
    
    public async Task<Shared.Model.Item> CreateAsync(ItemCreationDto dto)
    {
        if (dto.Antal<=0)
        { 
            throw new Exception("antal skal være mere end 0");
        }

        if (dto.ItemTypeId<=0)
        {
            throw new Exception("ItemType skal være større end 0");

        }
        Shared.Model.Item result = await _itemClient.Create(dto);
        
        return result;
    }

    public Task<ItemType> CreateItemTypeAsync(ItemTypeCreationDto dto)
    {
        throw new NotImplementedException();
    }

    public async Task<ItemType> createItemTypeAsync(ItemTypeCreationDto dto)
    {
        if (dto.Id<1)
        {
            throw new Exception("Id skal være større end 0");
        }

        if (dto.DimensionX<=0)
        {
            throw new Exception("Din X dim skal være større end 0");
        }
        
        if (dto.DimenstionY<=0)
        {
            throw new Exception("Din Y dim skal være større end 0");
        }
        
        if (dto.DimensionZ<=0)
        {
            throw new Exception("Din Z dim skal være større end 0");
        }
        return await _itemTypeClient.Create(dto);
    }


}