using GRPC.Proto;
using Shared.DTOs.Shelf;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterShelf
{
    
    
    public ShelfCreationRequest CreationToProto(ShelfCreationDto dto) {
        return new ShelfCreationRequest {
            RowNo = dto.RowNo,
            ShelfNo = dto.ShelfNo,
            ShelfDimX = dto.DimensionX,
            ShelfDimY = dto.DimensionY,
            ShelfDimZ = dto.DimensionY,
        };
    }

    public static Shelf ProtoToShelf(ShelfProto proto) {
        
        return new Shelf(proto.RowNo, proto.ShelfNo, proto.ShelfDimX, proto.ShelfDimY, proto.ShelfDimZ, ConverterItem.ProtoToList(proto.ItemsOnShelf));
    }

    public ShelfSearchRequest SearchToProto(ShelfSearchParametersDto dto) {
        throw new NotImplementedException();
    }

    public List<Shelf> ProtoToList(ShelvesListProto proto) {
        List<Shelf> returnList = new();

        foreach (var index in proto.Proto) {
            returnList.Add(ProtoToShelf(index));
        }

        return returnList;
    }
    
}