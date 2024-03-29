using ClientgRPC.ClientInterfaces;
using ClientgRPC.StaticBusiness;
using Grpc.Core;
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
    private IShelfClient shelfClient;
    private IShelfManager shelfManager;

    public ItemManager()
    {
    }
    
    public ItemManager(IItemClient itemClient, IItemTypeClient itemTypeClient, IShelfManager shelfManager, IShelfClient shelfClient)
    {
        
        _itemClient = itemClient;
        _itemTypeClient = itemTypeClient;
        this.shelfManager = shelfManager;
        this.shelfClient = shelfClient;
    }

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


    public async Task<Boolean> CheckType(ItemTypeSearchDto dto)
    {
        ItemType type = await _itemTypeClient.Read(dto);
        Console.WriteLine("Reads before or after?");
        return type.Id! != 0;
    }

    public async Task ReserveItem(ItemCreationDto dto) {

        int amount = dto.Antal;

        try
        {
            List<Shared.Model.Shelf> shelves = await shelfManager.ReadAll();

            ItemType type = await _itemTypeClient.Read(new ItemTypeSearchDto(dto.ItemTypeId));

            foreach (var index in shelves)
            {
                double roomAvailable = Amount.ShelfMass(index);

                foreach (var itemIndex in index.ItemsOnShelf)
                {
                    roomAvailable -= Amount.ItemTypeMass(itemIndex.Type);
                }
                
                Console.WriteLine("Room available: " + roomAvailable);

                int indexCount = amount;

                for (int i = 0; i < indexCount; i++)
                {
                    if (roomAvailable > Amount.ItemTypeMass(type)) {
                        Console.WriteLine("Room available: " + roomAvailable);
                        _itemClient.Create(new ItemCreationDto(dto.ItemTypeId, dto.Antal, dto.OwnerId, dto.Reserved, index.RowNo + index.ShelfNo));
                        roomAvailable -= Amount.ItemTypeMass(type);
                        amount -= 1;
                        Thread.Sleep(200);
                    }
                }
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
        }
    }

    public async Task<List<Shared.Model.Item>> ReadAllAsync()
    {
        try
        {
            List<Shared.Model.Item> items = await _itemClient.ReadAll();
            return items;
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            throw;
        }
    }
}