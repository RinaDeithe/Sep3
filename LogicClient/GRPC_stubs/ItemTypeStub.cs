

using ClientgRPC.ClientInterfaces;
using ClientgRPC.Converters;
using Grpc.Net.Client;
using GRPC.Proto;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs; 

public class ItemTypeStub : IItemTypeClient {
    
    private GrpcChannel _channel;
    private ItemTypeService.ItemTypeServiceClient _client;
    private ConverterItemType _converter;

    public ItemTypeStub() {
        _channel = GrpcChannel.ForAddress("http://localhost:9090");
        _client = new(_channel);
        _converter = new();
    }

    public Task<ItemType> Create(ItemTypeCreationDto dto) {
        ItemTypeCreationRequest request = _converter.CreationToProto(dto);

        return Task.FromResult(_converter.ProtoToType(_client.Create(request)));
    }

    public Task<ItemType> Read(ItemTypeSearchDto dto) {
        Console.WriteLine("Getting item");
        ItemTypeSearchRequest request = _converter.SearchToProto(dto);
        Console.WriteLine("Sending Item back");
        return Task.FromResult(_converter.ProtoToType(_client.Read(request)));
    }

    public Task<List<ItemType>> ReadAll() {
        return Task.FromResult(_converter.ProtoToList(_client.ReadAll(new emptyParams())));
    }

    public Task<ItemType> Update(ItemType entity) {
        throw new NotImplementedException();
    }

    public Task<ItemType> Delete(ItemTypeSearchDto dto) {
        ItemTypeSearchRequest request = _converter.SearchToProto(dto);

        return Task.FromResult(_converter.ProtoToType(_client.Delete(request)));
    }
}
