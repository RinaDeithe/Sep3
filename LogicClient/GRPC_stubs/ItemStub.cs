

using ClientgRPC.ClientInterfaces;
using ClientgRPC.Converters;
using Grpc.Net.Client;
using GRPC.Proto;
using Shared.DTOs.Item;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs; 

public class ItemStub : IItemClient {
    
    private GrpcChannel _channel;
    private ItemService.ItemServiceClient _client;
    private ConverterItem _converter; 

    public ItemStub() {
        _converter = new();
        _channel = GrpcChannel.ForAddress("http://localhost:9090");
        _client = new(_channel);
    }

    public async Task<Item> Create(ItemCreationDto dto) {
        ItemCreation request = _converter.CreationDtoToProto(dto);

        return ConverterItem.ProtoToItem(await _client.CreateAsync(request));
    }

    public async Task<Item> Read(ItemSearchDto dto) {
        ItemSearchRequest request = _converter.SearchDtoToProto(dto);

        return ConverterItem.ProtoToItem(await _client.ReadAsync(request));
    }

    public async Task<List<Item>> ReadAll()
    {
        var tets = await _client.ReadAllAsync(new emptyParams());
        Console.Write(tets);
        return ConverterItem.ProtoToList(tets);
    }

    public Task<Item> Update(Item entity) {
        ItemProto request = _converter.ItemToProto(entity);

        throw new NotImplementedException();
    }

    public async Task<Item> Delete(ItemSearchDto dto) {
        ItemSearchRequest request = _converter.SearchDtoToProto(dto);

        return ConverterItem.ProtoToItem(await _client.DeleteAsync(request));
    }

}
