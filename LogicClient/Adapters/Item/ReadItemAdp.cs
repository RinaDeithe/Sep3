using ClientgRPC.Converters;
using GRPC.Proto;
using Shared.DTOs.Item;

namespace ClientgRPC.Adapters.Item;

public class ReadItemAdp
{
    GRPCServerSide? GrpcServerSide { get;set; }

    public async Task<Shared.Model.Item> Read(ItemSearchDto dao)
    {
        ItemSearchRequest itemSearch = new ItemSearchRequest{Id = dao.id};
        ItemProto itemProto = await GrpcServerSide.GetItemGRPCAsync(itemSearch);

        Shared.Model.Item itemDomain = ConverterItem.ItemProtoToItem(itemProto);
        return itemDomain;
    }
}