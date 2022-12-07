using GRPC.Proto;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterItemType
{



    public static ItemTypeCreationRequest ItemTypeToItemTypeProto(ItemTypeCreationDto itemType)
    {
        return new ItemTypeCreationRequest {Id  = itemType.Id,DimX = itemType.DimensionX, DimY = itemType.DimenstionY, DimZ = itemType.DimensionZ };
    }

    public static ItemType ItemTypeProtoToItemType(ItemTypeProto itemTypeProto)
    {
      return new ItemType(itemTypeProto.Id, itemTypeProto.DimX, itemTypeProto.DimY, itemTypeProto.DimZ);
    }

    public static ItemTypeSearchRequest ItemTypeSearchDtoToItemTypeSearchRequest(ItemTypeSearchDto itemTypeSearchDto)
    {
        return new ItemTypeSearchRequest{Id = itemTypeSearchDto.id};
    }
   
}