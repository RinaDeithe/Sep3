﻿using GRPC.General;
using Shared.DTOs;
using Shared.Model;
using Shelf = Shared.Model.Shelf;
using User = GRPC.General.User;

namespace Logic.AdapterToGRPC.Item.Adapterne;

public class ReadItemAdp
{
    GRPCServerSide _grpcServerSide { get;set; }

    public async Task<Shared.Model.Item> Read(ItemSearchDto dao)
    {
        ItemSearchRequest itemSearch = new ItemSearchRequest{Id = dao.id};
        GRPC.General.Item itemProto = await _grpcServerSide.GetItemGRPCAsync(itemSearch);
        
        Shared.Model.User user = new Shared.Model.User();
        user.Id = itemProto.Owner.Id;
        
        Shared.Model.Shelf shelf = new Shared.Model.Shelf();
        shelf.DimX = itemProto.Shelf.Dimz;
        shelf.DimY = itemProto.Shelf.Dimy;
        shelf.DimZ = itemProto.Shelf.Dimz;
        shelf.RowNo = itemProto.Shelf.RowNo;
        shelf.ShelfNo = itemProto.Shelf.ShelfNo;
        
        shelf.ItemsOnShelf = new List<Shared.Model.Item>();
        foreach (var itemss in itemProto.Shelf.ItemsOnShelf)
        {
            Shared.Model.User userit = new Shared.Model.User();
        
            userit.Id = itemProto.Owner.Id;

            Shared.Model.Item item = new Shared.Model.Item(itemss.Type, itemss.UniqueID, userit, shelf);
            shelf.ItemsOnShelf.Add(item);
        }
        
        
        
        Shared.Model.Item itemDomain =
            new Shared.Model.Item(itemProto.Type,itemProto.UniqueID,user,shelf);

        return itemDomain;
    }
}