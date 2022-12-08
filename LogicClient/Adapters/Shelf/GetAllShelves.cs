using ClientgRPC;
using ClientgRPC.Converters;
using Google.Protobuf.WellKnownTypes;
using GRPC.Proto;

namespace Logic.AdapterToGRPC.Shelf.Adp;

public class GetAllShelves
{
    private readonly IGRPCServerSide _grpcServerSide;

    public GetAllShelves(IGRPCServerSide grpcServerSide)
    {
        _grpcServerSide = grpcServerSide;
    }

    public async Task<List<Shared.Model.Shelf>> GetRequest()
    {
        Empty request = new Empty();
        ShelfListProto shelfProtos = await _grpcServerSide.(request);
        List<Shared.Model.Shelf> shelves = ConverterShelf.AllShelvesProtoToAllShelves(shelfProtos);

        return shelves;
    }
    
}