using ClientgRPC.Adapters.Shelf;
using ClientgRPC.ClientInterfaces;
using ClientgRPC.GRPC_stubs;
using Logic.AdapterToGRPC.ItemType;
using Logic.AdapterToGRPC.Shelf.Adp;
using Logic.LogicInterfaces;
using Logic.Shelf;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace Logic.Logic;

public class ItemManager : IItemLogic, IItemManager
{
    IShelfClient _shelfClient = new ShelfClient(new ReadShelfAdp(), new UpdateShelfAdp());
    IItemClient _itemClient = new TypeMainAdapter();
    private IShelfManager shelfManager;

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

    public Task<Shared.Model.Item> CreateAsync(ItemSearchDto dto)
    {
        throw new NotImplementedException();
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

    public async Task<bool> CheckType(ItemTypeSearchDto dto)
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