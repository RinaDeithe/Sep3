using ClientgRPC.Converters;
using GRPC.Proto;
using LogicClient.Converters;
using Shared.DTOs.Item;

namespace LogicClient.Adapters.Item;

public class DeleteItemAdp
{
    private GRPCServerSide _grpcServerSide = new GRPCServerSide();

    public async Task<Shared.Model.Item> Delete(ItemSearchDto dao)
    {
        ItemSearchRequest itemSearch = new ItemSearchRequest{Id = dao.id};
        ItemProto itemProto = await _grpcServerSide.DeleteItemGRPCAsync(itemSearch);


        Shared.Model.Item itemDomain = ConverterItem.ItemProtoToItem(itemProto);

        return itemDomain;
    }
}