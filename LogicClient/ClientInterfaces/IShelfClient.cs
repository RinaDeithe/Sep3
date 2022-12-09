using Shared.DTOs.Shelf;
using Shared.Model;

namespace ClientgRPC.ClientInterfaces;

public interface IShelfClient
{
    Task<Shared.Model.Shelf> ReadShelf(ShelfSearchParametersDto dao);
    Task<Shared.Model.Shelf> UpdateShelf(Shared.Model.Shelf dao);
    Task<List<Shared.Model.Shelf>> GetAllShelves();

    Task<List<Shelf>> ReadAll();
}