using ClientgRPC.Converter;
using GRPC.Proto;
using Shared.DTOs;

namespace ClientgRPC.Adapters.ItemType.Selve_Adapterne;

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