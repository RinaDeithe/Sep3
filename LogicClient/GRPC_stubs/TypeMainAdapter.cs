using ClientgRPC.Adapters.Item;
using ClientgRPC.ClientInterfaces;
using Shared.DTOs.Item;

namespace ClientgRPC.GRPC_stubs;

public class TypeMainAdapter : IItemClient
{
    private readonly ItemCreateAdapter _itemCreateAdapter = new();
    private readonly ReadItemAdp _readItemAdp = new();
    private readonly DeleteItemAdp _deleteItemAdp = new() ;


    public TypeMainAdapter()
    {
        
    }

    public async Task<Shared.Model.Item> Create(ItemCreationDto dto)
    {
        Console.WriteLine($"antal = +{dto.Antal}; shelfId = {dto.shelfId}; OwnerId = {dto.OwnerId}; ItemTypeId = {dto.ItemTypeId}");


        return await _itemCreateAdapter.createItem(dto);
    }

    public async Task<Shared.Model.Item> Read(ItemSearchDto dao)
    {
        return await _readItemAdp.Read(dao);
    }

    public async Task<Shared.Model.Item> Delete(ItemSearchDto dao)
    {
        return await _deleteItemAdp.Delete(dao);
    }
}