﻿using ClientgRPC;
using GRPC.Proto;
using Shared.Model;


namespace Logic.AdapterToGRPC.Shelf.Adp;

public class UpdateShelfAdp
{
    private GRPCServerSide _grpcServerSide = new GRPCServerSide();
    public async Task<Shared.Model.Shelf> UpdateShelf(Shared.Model.Shelf dao)
    {
        ShelfProto shelfRequest = new ShelfProto
        {
            Dimy = dao.DimY, Dimz = dao.DimZ, DimX = dao.DimX, RowNo = dao.RowNo, ShelfNo = dao.ShelfNo
        };

        ShelfProto shelfProto = await _grpcServerSide.UpdateSelfAsync(shelfRequest);
        
        Shared.Model.Shelf shelf = new Shared.Model.Shelf();
        shelf.DimX = shelfProto.DimX;
        shelf.DimY = shelfProto.Dimy;
        shelf.DimZ = shelfProto.Dimz;
        shelf.RowNo = shelfProto.RowNo;
        shelf.ShelfNo = shelfProto.ShelfNo;
            
        shelf.ItemsOnShelf = new List<Shared.Model.Item>();
        foreach (var itemss in shelfProto.ItemsOnShelf)
        {
            Shared.Model.User userit = new Shared.Model.User();
            
            userit.Id = itemss.Owner.Id;
    
            itemType _itemType = new itemType(itemss.Type.Id, itemss.Type.DimX, itemss.Type.DimY, itemss.Type.DimZ);

            
            Shared.Model.Item item = new Shared.Model.Item(_itemType, itemss.UniqueID, userit, shelf);
            shelf.ItemsOnShelf.Add(item);
        }

        return shelf;
    }
}