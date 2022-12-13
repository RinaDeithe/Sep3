

using ClientgRPC.ClientInterfaces;
using ClientgRPC.Converters;
using Grpc.Net.Client;
using GRPC.Proto;
using Shared.DTOs.ItemType;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs; 

public class ItemTypeStub : IItemTypeClient {
    
    private readonly GrpcChannel _channel;
    private ItemTypeService.ItemTypeServiceClient _client;
    private ConverterItemType _converter;

    public ItemTypeStub() {
        _channel = GrpcChannel.ForAddress("http://localhost:9090");
        _client = new(_channel);
        _converter = new();
    }

    public async Task<ItemType> Create(ItemTypeCreationDto dto) {
        ItemTypeCreationRequest request = _converter.CreationToProto(dto);

        return ConverterItemType.ProtoToType(await _client.CreateAsync(request));
    }

    public async Task<ItemType> Read(ItemTypeSearchDto dto) {
        ItemTypeSearchRequest request = _converter.SearchToProto(dto);

        return ConverterItemType.ProtoToType(await _client.ReadAsync(request));
    }

    public async Task<List<ItemType>> ReadAll() {
        return _converter.ProtoToList(await _client.ReadAllAsync(new emptyParams()));
    }

    public Task<ItemType> Update(ItemType entity) {
        throw new NotImplementedException();
    }

    public async Task<ItemType> Delete(ItemTypeSearchDto dto) {
        ItemTypeSearchRequest request = _converter.SearchToProto(dto);

        return ConverterItemType.ProtoToType(await _client.DeleteAsync(request));
    }
}
