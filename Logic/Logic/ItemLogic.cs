using Logic.LogicInterfaces;
using Shared.DTOs;
using Shared.Model;

namespace Logic.Logic; 

public class ItemLogic : IItemLogic {
    public async Task<Shared.Model.Item> CreateAsync(ItemCreationDto dto) {
        throw new NotImplementedException();
    }
}