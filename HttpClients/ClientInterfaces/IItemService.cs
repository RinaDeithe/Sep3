using Shared.DTOs.Item;
using Shared.Model;

namespace HttpClients.ClientInterfaces; 

public interface IItemService {



    Task<Item> CreateAsync(ItemCreationDto dto);
    Task DeleItemAsync(ItemSearchDto dto);

    void ReserveItem(ItemCreationDto itemCreationDto);
}