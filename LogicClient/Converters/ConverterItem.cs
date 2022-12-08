using GRPC.Proto;
using Shared.DTOs.Item;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterItem
{
    public ItemCreation CreationDtoToProto(ItemCreationDto dto) {
        
        return new ItemCreation
            { ItemTypeID = dto.ItemTypeId, ShelfID = (int) dto.shelfId!, OwnerID = dto.OwnerId };
    }

    public static Item ProtoToItem(ItemProto proto) {
        return new Item(new ItemType(proto.Type.Id, proto.Type.DimX, proto.Type.DimY, proto.Type.DimZ), proto.UniqueID,
            new User(proto.UniqueID, "temp"), ConverterShelf.ProtoToShelf(proto.Shelf));
    }

    public ItemSearchRequest SearchDtoToProto(ItemSearchDto dto) {
        return new ItemSearchRequest {
            Id = dto.id
        };
    }

    public static List<Item> ProtoToList(ItemListProto proto) {
        List<Item> returnList = new();

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