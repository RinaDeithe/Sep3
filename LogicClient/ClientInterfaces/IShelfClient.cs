using Shared.DTOs.Shelf;
using Shared.Model;

namespace ClientgRPC.ClientInterfaces;

public interface IShelfClient
{
    Task<Shelf> Create(ShelfCreationDto dto);
    Task<Shelf> Read(ShelfSearchParametersDto dao);
    Task<List<Shelf>> ReadAll();
    Task<Shelf> Update(Shelf entity);
    Task<Shelf> Delete(ShelfSearchParametersDto dto);
}