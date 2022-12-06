using GRPC.Proto;
using LogicClient.Converters;
using Shared.DTOs.ItemType;

namespace LogicClient.Adapters.ItemType;

public class ReadItemTypeAdapter
{
    private readonly IGRPCServerSide _grpcServerSide;

    public ReadItemTypeAdapter(IGRPCServerSide grpcServerSide)
    {
        _grpcServerSide = grpcServerSide;
    }

    public async Task<Shared.Model.ItemType> ReadItem(ItemTypeSearchDto dto)
    {
        ItemTypeSearchRequest itemTypeSearch = ConverterItemType.ItemTypeSearchDtoToItemTypeSearchRequest(dto);
        ItemTypeProto itemTypeProto = await _grpcServerSide.SearchItemTypeGRPC(itemTypeSearch);
        Shared.Model.ItemType itemTypeDomain = ConverterItemType.ItemTypeProtoToItemType(itemTypeProto);

        return itemTypeDomain;

    }
}