using GRPC.Proto;

namespace ClientgRPC.Adapters.Shelf;

public class UpdateShelfAdp
{
    private readonly IGRPCServerSide _grpcServerSide = new GRPCServerSide();

    /*
    public UpdateShelfAdp(IGRPCServerSide grpcServerSide)
    {
        _grpcServerSide = grpcServerSide;
    }
    */

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
            Shared.Model.User userit = new Shared.Model.User(itemss.Owner.Id, null);

            Shared.Model.ItemType _itemType = new Shared.Model.ItemType(itemss.Type.Id, itemss.Type.DimX, itemss.Type.DimY, itemss.Type.DimZ);

            
            Shared.Model.Item item = new Shared.Model.Item(_itemType, itemss.UniqueID, userit, shelf);
            shelf.ItemsOnShelf.Add(item);
        }

        return shelf;
    }
}