using Shared.DTOs.ItemType;
using Shared.Model;

namespace ClientgRPC.ClientInterfaces;

public interface IItemTypeClient
{
    Task<ItemType> Create(ItemTypeCreationDto dto);
    Task<ItemType> Read(ItemTypeSearchDto dto);

}