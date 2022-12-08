using ClientgRPC.Adapters.Item;
using ClientgRPC.Adapters.ItemType;
using ClientgRPC.ClientInterfaces;
using Shared.DTOs.Item;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs;

public class ItemTypeClient: IItemTypeClient
{
    
    private readonly ItemTypeCreateAdapter saveadp = new();
    private readonly ReadItemTypeAdapter readadp = new();

    
    public ItemTypeClient(ItemTypeCreateAdapter saveadp, ReadItemTypeAdapter readadp)
    {
        this.saveadp = saveadp;
        this.readadp = readadp;
    }

    public async Task<ItemType> Create(ItemTypeCreationDto dto)
    {
        
        return await saveadp.CreateAdapter(dto);
    }

    public async Task<ItemType> Read(ItemTypeSearchDto dto)
    {

        
 
        return await readadp.ReadItem(dto);
    }
}