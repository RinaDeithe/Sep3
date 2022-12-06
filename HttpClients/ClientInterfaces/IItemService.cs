using Shared.DTOs;
using Shared.DTOs.Item;
using Shared.Model;

namespace HttpClients.ClientInterfaces; 

public interface IItemService {



    Task<Item> CreateAsync(ItemCreationDto dto);

}