using ClientgRPC.Converter;
using GRPC.Proto;
using Shared.DTOs;

namespace ClientgRPC.Adapters.Item.Adapterne;

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