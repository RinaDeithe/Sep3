using ClientgRPC.Converter;
using GRPC.Proto;
using Shared.DTOs;

namespace ClientgRPC.Adapters.Item.Adapterne;

public class ItemCreateAdapter
{
    private readonly IGRPCServerSide _grpcServerSide;


    public ItemCreateAdapter(IGRPCServerSide grpcServerSide)
    {
        _grpcServerSide = grpcServerSide;
    }

    public async Task<Shared.Model.Item> createItem(ItemCreationDto dto)
    {
        GRPC.Proto.ItemCreation itemCreationProto = ConverterItem.ItemCreationDtoToItemCreation(dto);
        ItemProto itemProto = await _grpcServerSide.CreateItemGRPCAsync(itemCreationProto);

        Shared.Model.Item itemDomain = ConverterItem.ItemProtoToItem(itemProto);
        
        return itemDomain;
    }
}