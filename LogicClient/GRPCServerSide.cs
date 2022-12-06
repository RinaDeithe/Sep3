// See https://aka.ms/new-console-template for more information


using Grpc.Net.Client;
using GRPC.Proto;

namespace LogicClient;

public class GRPCServerSide : IGRPCServerSide{
    
    public async  Task<ShelfProto> GetShelf(ShelfSearchRequest dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _shelvesClient = new Serivce.SerivceClient(_channel);
        ShelfProto shelfProto = await _shelvesClient.getShelfAsync(dto);
        return shelfProto;
    }


    public async Task<ItemProto> GetItem(ItemSearchRequest dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _itemClient = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _itemClient.ReadItemAsync(dto);
        return itemProto;
    }

    public async Task<ItemTypeProto> CreateItemTypeGRPC(ItemTypeCreationRequest dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _itemType = new Serivce.SerivceClient(_channel);
        ItemTypeProto itemTypeProto = await _itemType.CreateItemTypeAsync(dto);
        return itemTypeProto;
    }

    public async Task<ItemTypeProto> SearchItemTypeGRPC(ItemTypeSearchRequest dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _itemType = new Serivce.SerivceClient(_channel);
        ItemTypeProto itemTypeProto = await _itemType.ReadItemTypeAsync(dto);
        return itemTypeProto;   
    }

    public async Task<ItemProto> CreateItemGRPCAsync(ItemCreation dto)
    {
        Console.WriteLine(dto);
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _item = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _item.CreateItemAsync(dto);
        return itemProto;   
    }

    public async Task<ItemProto> GetItemGRPCAsync(ItemSearchRequest dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _item = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _item.ReadItemAsync(dto);
        Console.WriteLine(dto);
        return itemProto;    
    }

    public async Task<ItemProto> DeleteItemGRPCAsync(ItemSearchRequest dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _item = new Serivce.SerivceClient(_channel);
        ItemProto itemProto = await _item.DeleteItemAsync(dto);
        return itemProto;
    }


    public async Task<ShelfProto> ReadShelfAsync(ShelfSearchRequest dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _shelf = new Serivce.SerivceClient(_channel);
        ShelfProto shelfProto = await _shelf.getShelfAsync(dto);
        return shelfProto;
    }

    public async Task<ShelfProto> UpdateSelfAsync(ShelfProto dto)
    {
        var _channel = GrpcChannel.ForAddress("http://localhost:9090");
        var _shelf = new Serivce.SerivceClient(_channel);
        ShelfProto shelfProto = await _shelf.UpdateShelfAsync(dto);
        return shelfProto;
    }

}