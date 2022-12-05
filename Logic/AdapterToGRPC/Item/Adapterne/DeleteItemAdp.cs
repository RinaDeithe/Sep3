﻿using ClientgRPC;
using GRPC.Proto;
using Shared.DTOs;
using Shared.Model;
using Shelf = Shared.Model.Shelf;

namespace Logic.AdapterToGRPC.Item.Adapterne;

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