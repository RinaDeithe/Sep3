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

    public static Shelf ProtoToShelf(ShelfProto proto)
    {
        List<Item> items = new List<Item>();
        Shelf shelf = new Shelf(proto.RowNo, proto.ShelfNo, proto.ShelfDimX, proto.ShelfDimY, proto.ShelfDimZ,items);
        if (proto.ItemsOnShelf==null)
        {
            return shelf;
        }
        foreach (ItemProto protofile in proto.ItemsOnShelf.List)
        {
            items.Add(new Item(ConverterItemType.ProtoToType(protofile.Type), 
                protofile.UniqueID,
                ConverterUser.ProtoToUser(protofile.Owner),shelf));
        }
        
        return shelf;
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