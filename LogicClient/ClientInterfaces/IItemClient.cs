using Shared.DTOs;

namespace ClientgRPC.ClientInterfaces;

public interface IItemClient
{
    Task<Shared.Model.Item> Create(ItemCreationDto dto);
    Task<Shared.Model.Item> Read(ItemSearchDto dao);
    Task<Shared.Model.Item> Delete(ItemSearchDto dao);

}