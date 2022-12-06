using GRPC.Proto;
using LogicClient.Converters;
using Shared.DTOs.Shelf;

namespace LogicClient.Adapters.Shelf;

public class ReadShelfAdp
{
    GRPCServerSide? GrpcServerSide { get;set; }

    public async Task<Shared.Model.Shelf> ReadShelf(ShelfSearchParametersDto dao){
    ShelfSearchRequest shelfSearchRequest = new ShelfSearchRequest{Id = dao.id};
            ShelfProto shelfProto = await GrpcServerSide.ReadShelfAsync(shelfSearchRequest);

            Shared.Model.Shelf shelf = ConverterShelf.ShelfProtoToShelf(shelfProto);
            




            return shelf;
    }
}