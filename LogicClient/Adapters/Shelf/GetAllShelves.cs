using ClientgRPC;
using ClientgRPC.Converters;
using Google.Protobuf.WellKnownTypes;
using GRPC.Proto;
using Empty = GRPC.Proto.Empty;

namespace Logic.AdapterToGRPC.Shelf.Adp;

public class GetAllShelves
{
    private readonly IGRPCServerSide _grpcServerSide = new GRPCServerSide();



    public async Task<List<Shared.Model.Shelf>> GetRequest()
    {
        Empty request = new Empty();
        ShelfListProtoReturn shelfProtos = await _grpcServerSide.GetAllShelvsGRPCAsync(request);
        List<Shared.Model.Shelf> shelves = ConverterShelf.AllShelvesProtoToAllShelves(shelfProtos);

        return shelves;
    }
    
}