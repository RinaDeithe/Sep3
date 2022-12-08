using ClientgRPC.Converters;
using GRPC.Proto;
using Shared.DTOs.ItemType;

namespace ClientgRPC.Adapters.ItemType;

public class ItemTypeCreateAdapter
{
    
    private IGRPCServerSide _grpcServerSide;

    public ItemTypeCreateAdapter()
    {
        
    }

    public async Task<Shared.Model.ItemType>  CreateAdapter(ItemTypeCreationDto dto)
    {
        ItemTypeCreationRequest itemCreationProt = ConverterItemType.ItemTypeToItemTypeProto(dto);
        ItemTypeProto itemTypeProto = await _grpcServerSide.CreateItemTypeGRPC(itemCreationProt);
        Shared.Model.ItemType itemTypeDomain = ConverterItemType.ItemTypeProtoToItemType(itemTypeProto);
            
        return itemTypeDomain;

    }
    
}