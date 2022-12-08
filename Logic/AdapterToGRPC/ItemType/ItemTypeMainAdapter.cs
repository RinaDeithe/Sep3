using Logic.AdapterToGRPC.Item;
using Shared.DTOs;
using Shared.Model;

namespace Logic.AdapterToGRPC.ItemType;

public class ItemTypeMainAdapter: IItemTypeClient
{
    
    private readonly ItemTypeCreateAdapter saveadp = new ();
    private readonly ReadItemTypeAdapter readadp = new ();
    

    public async Task<itemType> Create(ItemTypeCreationDto dto)
    {
        
        return await saveadp.CreateAdapter(dto);
    }

    public async Task<itemType> Read(ItemTypeSearchDto dto)
    {

        return await readadp.ReadItem(dto);
    }
}