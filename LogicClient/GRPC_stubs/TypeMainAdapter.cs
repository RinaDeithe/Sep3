using ClientgRPC.Adapters.Item;
using ClientgRPC.ClientInterfaces;
using Shared.DTOs.Item;

namespace ClientgRPC.GRPC_stubs;

public class TypeMainAdapter : IItemClient
{
    private readonly ItemCreateAdapter _itemCreateAdapter;
    private readonly ReadItemAdp _readItemAdp;
    private readonly DeleteItemAdp _deleteItemAdp ;


    public TypeMainAdapter(ItemCreateAdapter itemCreateAdapter, ReadItemAdp readItemAdp, DeleteItemAdp deleteItemAdp)
    {
        _itemCreateAdapter = itemCreateAdapter;
        _readItemAdp = readItemAdp;
        _deleteItemAdp = deleteItemAdp;
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