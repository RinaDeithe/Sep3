using ClientgRPC.Adapters.ItemType;
using ClientgRPC.ClientInterfaces;
using Logic.AdapterToGRPC.Item;
using Shared.DTOs;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace Logic.AdapterToGRPC.ItemType;

public class ItemTypeMainAdapter: IItemTypeClient
{
    
    private readonly ItemTypeCreateAdapter saveadp = new ();
    private readonly ReadItemTypeAdapter readadp = new ();
    

    public async Task<Shared.Model.ItemType> Create(ItemTypeCreationDto dto)
    {
        
        return await saveadp.CreateAdapter(dto);
    }

    public async Task<Shared.Model.ItemType> Read(ItemTypeSearchDto dto)
    {

        return await readadp.ReadItem(dto);
    }
    
    
}