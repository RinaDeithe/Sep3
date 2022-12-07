using Shared.DTOs;
using Shared.Model;

namespace HttpClients.ClientInterfaces; 

public interface IItemService {



    Task<Item> CreateAsync(ItemCreationDto dto);
    Task DeleItemAsync(ItemSearchDto dto);

}