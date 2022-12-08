using Shared.DTOs.Item;
using Shared.Model;

namespace ClientgRPC.ClientInterfaces;

public interface IItemClient
{
    Task<Item> Create(ItemCreationDto dto);
    Task<Item> Read(ItemSearchDto dto);
    Task<List<Item>> ReadAll();
    Task<Item> Update(Item entity);
    Task<Item> Delete(ItemSearchDto dto);

}