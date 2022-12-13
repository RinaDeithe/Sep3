using GRPC.Proto;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterItemType
{

    public ItemTypeCreationRequest CreationToProto(ItemTypeCreationDto dto) {
        return new ItemTypeCreationRequest { Id = dto.Id, ItemDimX = dto.DimensionX, ItemDimY = dto.DimenstionY, ItemDimZ = dto.DimensionZ};
    }

    public static ItemType ProtoToType(ItemTypeProto proto) {
        return new ItemType(proto.Id, proto.DimX, proto.DimY, proto.DimZ);
    }

    public ItemTypeSearchRequest SearchToProto(ItemTypeSearchDto dto) {
        return new ItemTypeSearchRequest {
            Id = dto.Id
        };
    }

    public List<ItemType> ProtoToList(ItemTypeListProto proto) {
        List<ItemType> typeList = new List<ItemType>();

        foreach (var index in proto.List) {
            typeList.Add(ProtoToType(index));
        }

        return typeList;
    }
    
}