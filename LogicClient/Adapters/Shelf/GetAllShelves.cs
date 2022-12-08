using ClientgRPC;
using Google.Protobuf.WellKnownTypes;
using GRPC.Proto;

namespace Logic.AdapterToGRPC.Shelf.Adp;

public class GetAllShelves
{
    private readonly IGRPCServerSide _grpcServerSide = new GRPCServerSide();
/*
    public GetAllShelves(IGRPCServerSide grpcServerSide)
    {
        _grpcServerSide = grpcServerSide;
    }

    public async Task<List<Shared.Model.Shelf>> GetRequest()
    {
        getAllRequest request = new getAllRequest();
        ShelvesListProto shelfProtos = await _grpcServerSide.GetAllShelfAsync(request);
        List<Shared.Model.Shelf> shelves = ConverterShelf.AllShelvesProtoToAllShelves(shelfProtos);

        return shelves;
    }
    */
}