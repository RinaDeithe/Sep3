

using ClientgRPC.ClientInterfaces;
using ClientgRPC.Converters;
using Grpc.Net.Client;
using GRPC.Proto;
using Shared.DTOs.Shelf;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs; 

public class ShelfStub : IShelfClient {
    private GrpcChannel _channel;
    private ShelfService.ShelfServiceClient _client;
    private ConverterShelf _converter;

    public ShelfStub() {
        _channel = GrpcChannel.ForAddress("http://localhost:9090");
        _client = new (_channel);
        _converter = new();
    }

    public async Task<Shelf> Create(ShelfCreationDto dto) {
        ShelfCreationRequest request = _converter.CreationToProto(dto);

        return  ConverterShelf.ProtoToShelf(await _client.CreateAsync(request));
    }

    public async Task<Shelf> Read(ShelfSearchParametersDto dto) {
        ShelfSearchRequest request = _converter.SearchToProto(dto);

        return ConverterShelf.ProtoToShelf(await _client.ReadAsync(request));
    }

    public async Task<List<Shelf>> ReadAll() {
        List<Shelf> result = _converter.ProtoToList(await _client.ReadAllAsync(new emptyParams()));
        return result;
    }

    public Task<Shelf> Update(Shelf entity) {
        throw new NotImplementedException();
    }

    public Task<Shelf> Delete(ShelfSearchParametersDto dto) {
        ShelfSearchRequest request = _converter.SearchToProto(dto);

        return Task.FromResult(ConverterShelf.ProtoToShelf(_client.Delete(request)));
    }
}
