using GRPC.Proto;

namespace ClientgRPC;

public interface IGRPCServerSide
{
    Task<ShelfProto> GetShelf(ShelfSearchRequest dto);
    Task<ItemProto> GetItem(ItemSearchRequest dto);
    Task<ItemTypeProto> CreateItemTypeGRPC(ItemTypeCreationRequest dto);
    Task<ItemTypeProto> SearchItemTypeGRPC(ItemTypeSearchRequest dto);
    Task<ItemProto> CreateItemGRPCAsync(ItemCreation dto);
    Task<ItemProto> GetItemGRPCAsync(ItemSearchRequest dto);
    Task<ItemProto> DeleteItemGRPCAsync(ItemSearchRequest dto);
    Task<ShelfProto> ReadShelfAsync(ShelfSearchRequest dto);
    Task<ShelfProto> UpdateSelfAsync(ShelfProto dto);
}