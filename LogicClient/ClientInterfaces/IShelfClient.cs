using Shared.DTOs;
using Shared.DTOs.Shelf;

namespace LogicClient.ClientInterfaces;

public interface IShelfClient
{
    Task<Shared.Model.Shelf> ReadShelf(ShelfSearchParametersDto dao);
    Task<Shared.Model.Shelf> UpdateShelf(Shared.Model.Shelf dao);
    Task<List<Shared.Model.Shelf>> GetAllShelves();
}