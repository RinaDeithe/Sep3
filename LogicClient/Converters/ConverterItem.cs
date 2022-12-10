using Google.Protobuf;
using Google.Protobuf.WellKnownTypes;
using GRPC.Proto;
using Shared.DTOs.Item;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterItem
{
    
    public ItemCreation CreationDtoToProto(ItemCreationDto dto) {
        
        return new ItemCreation
            { ItemTypeID = dto.ItemTypeId, ShelfID = dto.shelfId, OwnerID = dto.OwnerId };
    }

    public static Item ProtoToItem(ItemProto proto) {
        if (!proto.IsInitialized())
        {
            return new Item(null,0,null,null);
        }
        return new Item(new ItemType(proto.Type.Id, proto.Type.DimX, proto.Type.DimY, proto.Type.DimZ), proto.UniqueID,
            new User(proto.Owner.Id, "temp"), ConverterShelf.ProtoToShelf(proto.Shelf));
    }

    public ItemSearchRequest SearchDtoToProto(ItemSearchDto dto) {
        return new ItemSearchRequest {
            Id = dto.id
        };
    }

    public static List<Item> ProtoToList(ItemListProto proto) {
        List<Item> returnList = new();
        if (proto==null)
        {
            return returnList;
        }

        foreach (var index in proto.List) {
            returnList.Add(ProtoToItem(index));
        }

        return returnList;
    }

    public ItemProto ItemToProto(Item entity) {
        return new ItemProto {
            Owner = ConverterUser.UserToUserProto(entity.Owner),
            Shelf = new ShelfProto {
                ShelfDimX = entity.Shelf.DimX,
                ShelfDimY = entity.Shelf.DimY,
                ShelfDimZ = entity.Shelf.DimZ,
                ShelfNo = entity.Uid.ToString(),
                RowNo = entity.Uid.ToString()
            },
            Type = new ItemTypeProto {
                Id = entity.Type.Id,
                DimX = entity.Type.DimX,
                DimY = entity.Type.DimY,
                DimZ = entity.Type.DimZ
            },
            UniqueID = entity.Uid

        };
    }
    
}