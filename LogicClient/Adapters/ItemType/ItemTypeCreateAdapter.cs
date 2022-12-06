using GRPC.Proto;
using LogicClient.Converters;
using Shared.DTOs.ItemType;

namespace LogicClient.Adapters.ItemType;

public class ItemTypeCreateAdapter
{
    
    private IGRPCServerSide _grpcServerSide;

    public ItemTypeCreateAdapter(IGRPCServerSide grpcServerSide)
    {
        _grpcServerSide = grpcServerSide;
    }

    public async Task<Shared.Model.ItemType>  CreateAdapter(ItemTypeCreationDto dto)
    {
        ItemTypeCreationRequest itemCreationProt = ConverterItemType.ItemTypeToItemTypeProto(dto);
        ItemTypeProto itemTypeProto = await _grpcServerSide.CreateItemTypeGRPC(itemCreationProt);
        Shared.Model.ItemType itemTypeDomain = ConverterItemType.ItemTypeProtoToItemType(itemTypeProto);
            
        return itemTypeDomain;

    }
    
}