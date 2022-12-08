using ClientgRPC.Adapters.Shelf;
using ClientgRPC.ClientInterfaces;
using Logic.AdapterToGRPC.Shelf.Adp;
using Shared.DTOs.Shelf;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs;

public class ShelfClient : IShelfClient
{
    private readonly ReadShelfAdp _readShelfAdp;
    private readonly UpdateShelfAdp _updateShelfAdp;

    public ShelfClient(ReadShelfAdp readShelfAdp, UpdateShelfAdp updateShelfAdp)
    {
        _readShelfAdp = readShelfAdp;
        _updateShelfAdp = updateShelfAdp;
    }

    public async Task<Shared.Model.Shelf> ReadShelf(ShelfSearchParametersDto dao)
    {
        return await _readShelfAdp.ReadShelf(dao);
    }

    public async Task<Shared.Model.Shelf> UpdateShelf(Shared.Model.Shelf dao)
    {
        return await _updateShelfAdp.UpdateShelf(dao);
    }

    public Task<List<Shelf>> GetAllShelves()
    {
        throw new NotImplementedException();
    }
}