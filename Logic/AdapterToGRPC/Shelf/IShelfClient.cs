using Shared.DTOs;

namespace Logic.AdapterToGRPC.Shelf;

public interface IShelfClient
{
    Task<Shared.Model.Shelf> ReadShelf(ShelfSearchParametersDto dao);
    Task<Shared.Model.Shelf> UpdateShelf(Shared.Model.Shelf dao);
}