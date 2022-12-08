using Shared.DTOs;
using Shared.DTOs.Item;
using Shared.Model;


namespace Logic.LogicInterfaces; 

public interface IItemLogic {
    Task<Shared.Model.Item> CreateAsync(ItemSearchDto dto);
    Task DeleteItemAsync(ItemSearchDto dto);



}