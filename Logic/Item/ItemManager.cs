using ClientgRPC.ClientInterfaces;
using ClientgRPC.StaticBusiness;
using Logic.Shelf;
using Microsoft.AspNetCore.Mvc;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.Model;
namespace Logic.Item; 

public class ItemManager : IItemLogic
{
    private IItemClient _itemClient;
    private IItemTypeClient _itemTypeClient;
    private IShelfManager shelfManager;

    public ItemManager()
    {
        
    }

    public ItemManager(IItemClient itemClient, IItemTypeClient itemTypeClient)
    {
        
        _itemClient = itemClient;
        _itemTypeClient = itemTypeClient;
    }

    public async Task<Shared.Model.Item> CreateAsync(ItemCreationDto dto)
    {
        if (dto.Antal <= 0)
        {
            throw new Exception("antal skal være mere end 0");
        }

        if (dto.ItemTypeId <= 0)
        {
            throw new Exception("itemType skal være større end 0");

        }

        Shared.Model.Item result = await _itemClient.Create(dto);

        return result;
    }

    public async Task<ItemType> CreateItemTypeAsync(ItemTypeCreationDto dto)
    {
        if (dto.Id < 1)
        {
            throw new Exception("Id skal være større end 0");
        }

        if (dto.DimensionX <= 0)
        {
            throw new Exception("Din X dim skal være større end 0");
        }

        if (dto.DimenstionY <= 0)
        {
            throw new Exception("Din Y dim skal være større end 0");
        }

        if (dto.DimensionZ <= 0)
        {
            throw new Exception("Din Z dim skal være større end 0");
        }

        return await _itemTypeClient.Create(dto);
    }

    public async Task<ItemType> ReadItemTypeAsync(ItemTypeSearchDto dto)
    {
        if (dto.Id < 0)
        {
            throw new Exception("Id må ikke være lavere end 0");
        }
        
        try
        {
            ItemType result = await _itemTypeClient.Read(dto);
            Console.WriteLine(result.Id);
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
            if (item.Uid != dto.id)
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

    public async Task<ActionResult<bool>> CheckType(ItemTypeSearchDto dto)
    {
        if (_itemTypeClient.Read(dto).Result == null)
        {
            return false;
        }

        return true;
    }

    public async Task ReserveItem(ItemCreationDto dto)
    {
        List<Shared.Model.Shelf> shelves = shelfManager.ReadAll();

        ItemType type = await _itemTypeClient.Read(new ItemTypeSearchDto(dto.ItemTypeId));

        foreach (var index in shelves)
        {
            double roomAvailable = Amount.ShelfMass(index);

            foreach (var itemIndex in index.ItemsOnShelf)
            {
                roomAvailable -= Amount.ItemTypeMass(itemIndex.Type);
            }

            if (roomAvailable > Amount.ItemTypeMass(type))
            {
                _itemClient.Create(dto);
                return;
            }
        }
    }
}