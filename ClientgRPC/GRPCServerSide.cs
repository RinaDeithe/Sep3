// See https://aka.ms/new-console-template for more information


using Grpc.Net.Client;
using GRPC.Proto;

namespace ClientgRPC;

public class GRPCServerSide : IGRPCServerSide{
    
    public async  Task<ShelfProto> GetShelf(ShelfSearchRequest search)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _shelvesClient = new Serivce.SerivceClient(_channel);
        ShelfProto shelfProto = await _shelvesClient.getShelfAsync(search);
        return shelfProto;
    }


    public async Task<ItemProto> GetItem(ItemSearchRequest search)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _itemClient = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _itemClient.ReadItemAsync(search);
        return itemProto;
    }

    public async Task<ItemTypeProto> CreateItemTypeGRPC(ItemTypeCreationRequest dao)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _itemType = new Serivce.SerivceClient(_channel);
        ItemTypeProto itemTypeProto = await _itemType.CreateItemTypeAsync(dao);
        return itemTypeProto;
    }

    public async Task<ItemTypeProto> SearchItemTypeGRPC(ItemTypeSearchRequest dao)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _itemType = new Serivce.SerivceClient(_channel);
        ItemTypeProto itemTypeProto = await _itemType.ReadItemTypeAsync(dao);
        return itemTypeProto;   
    }

    public async Task<ItemProto> CreateItemGRPCAsync(ItemCreation dao)
    {
        Console.WriteLine(dao);
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _item = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _item.CreateItemAsync(dao);
        return itemProto;   
    }

    public async Task<ItemProto> GetItemGRPCAsync(ItemSearchRequest dao)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _item = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _item.ReadItemAsync(dao);
        Console.WriteLine(dao);
        return itemProto;    
    }

    public async Task<ItemProto> DeleteItemGRPCAsync(ItemSearchRequest dao)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _item = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _item.DeleteItemAsync(dao);
        return itemProto;
    }


    public async Task<ShelfProto> ReadShelfAsync(ShelfSearchRequest dao)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _shelf = new Serivce.SerivceClient(_channel);
        ShelfProto shelfProto = await _shelf.getShelfAsync(dao);
        return shelfProto;
    }

    public async Task<ShelfProto> UpdateSelfAsync(ShelfProto dao)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _shelf = new Serivce.SerivceClient(_channel);
        ShelfProto shelfProto = await _shelf.UpdateShelfAsync(dao);
        return shelfProto;
    }

}