using ClientgRPC;
using GRPC.Proto;
using Shared.DTOs;
using Shared.Model;
using Shelf = Shared.Model.Shelf;

namespace Logic.AdapterToGRPC.Item.Adapterne;

public class ReadItemAdp
{
    private readonly IGRPCServerSide _grpcServerSide = new GRPCServerSide();

    

    public async Task<Shared.Model.Item> Read(ItemSearchDto dao)
    {
        ItemSearchRequest itemSearch = new ItemSearchRequest{Id = dao.id};
        ItemProto itemProto = await _grpcServerSide.GetItemGRPCAsync(itemSearch);

        Shared.Model.Item itemDomain = ConverterItem.ItemProtoToItem(itemProto);
        return itemDomain;
    }
}