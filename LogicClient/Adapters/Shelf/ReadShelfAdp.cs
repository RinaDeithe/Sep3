using ClientgRPC.Converter;
using GRPC.Proto;
using Shared.DTOs;

namespace ClientgRPC.Adapters.Shelf.Adp;

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