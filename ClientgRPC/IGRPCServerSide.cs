using GRPC.Proto;

namespace ClientgRPC;

public interface IGRPCServerSide
{
    Task<ShelfProto> GetShelf(ShelfSearchRequest search);
    Task<ItemProto> GetItem(ItemSearchRequest search);
    Task<ItemTypeProto> CreateItemTypeGRPC(ItemTypeCreationRequest dao);
    Task<ItemTypeProto> SearchItemTypeGRPC(ItemTypeSearchRequest dao);
    Task<ItemProto> CreateItemGRPCAsync(ItemCreation dao);
    Task<ItemProto> GetItemGRPCAsync(ItemSearchRequest dao);
    Task<ItemProto> DeleteItemGRPCAsync(ItemSearchRequest dao);
    Task<ShelfProto> ReadShelfAsync(ShelfSearchRequest dao);
    Task<ShelfProto> UpdateSelfAsync(ShelfProto dao);
}