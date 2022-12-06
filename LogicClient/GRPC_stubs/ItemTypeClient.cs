using ClientgRPC.Adapters.ItemType.Selve_Adapterne;
using ClientgRPC.ClientInterfaces;
using Shared.DTOs;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs;

public class ItemTypeClient: IItemTypeClient
{
    
    private readonly ItemTypeCreateAdapter saveadp;
    private readonly ReadItemTypeAdapter readadp;

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