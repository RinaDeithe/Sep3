using ClientgRPC.ClientInterfaces;
using ClientgRPC.GRPC_stubs;
using Logic.AdapterToGRPC.Item;
using Logic.AdapterToGRPC.ItemType;
using Logic.AdapterToGRPC.Shelf;
using Logic.LogicInterfaces;
using Microsoft.AspNetCore.Http;
using Shared.DTOs;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace Logic.Logic; 

public class ItemManager : IItemLogic, IItemManager
{
    IShelfClient _shelfClient = new ShelfClient();
    IItemClient _itemClient = new TypeMainAdapter(); 
    IItemTypeClient _itemTypeClient = new ItemTypeMainAdapter();
/*
    public ItemManager(IShelfClient shelfClient, IItemClient itemClient, IItemTypeClient itemTypeClient)
    {
        _shelfClient = shelfClient;
        _itemClient = itemClient;
        _itemTypeClient = itemTypeClient;
    }
*/
    public async Task<Shared.Model.Item> CreateAsync(ItemCreationDto dto)
    {
        if (dto.Antal<=0)
        { 
            throw new Exception("antal skal være mere end 0");
        }

        if (dto.ItemTypeId<=0)
        {
            throw new Exception("itemType skal være større end 0");

        }
        Shared.Model.Item result = await _itemClient.Create(dto);
        
        return result;
    }

    public async Task<ItemType> CreateItemTypeAsync(ItemTypeCreationDto dto)
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

    public async Task<ItemType> ReadItemTypeAsync(ItemTypeSearchDto dto)
    {
        try
        {
            ItemType result = await _itemTypeClient.Read(dto);
            return result;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }

    public async Task DeleteItemAsync(ItemSearchDto dto)
    {
        try
        {
            Shared.Model.Item item = await _itemClient.Delete(dto);
            if (item.Uid!=dto.id)
            {
                throw new Exception("Item Not Found");
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
    
}