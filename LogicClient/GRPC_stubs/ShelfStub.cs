

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

    public Task<Shelf> Create(ShelfCreationDto dto) {
        ShelfCreationRequest request = _converter.CreationToProto(dto);

        return Task.FromResult(ConverterShelf.ProtoToShelf(_client.Create(request)));
    }

    public Task<Shelf> Read(ShelfSearchParametersDto dto) {
        ShelfSearchRequest request = _converter.SearchToProto(dto);

        return Task.FromResult(ConverterShelf.ProtoToShelf(_client.Read(request)));
    }

    public Task<List<Shelf>> ReadAll() {
        return Task.FromResult(_converter.ProtoToList(_client.ReadAll(new emptyParams())));
    }

    public Task<Shelf> Update(Shelf entity) {
        throw new NotImplementedException();
    }

    public Task<Shelf> Delete(ShelfSearchParametersDto dto) {
        ShelfSearchRequest request = _converter.SearchToProto(dto);

        return Task.FromResult(ConverterShelf.ProtoToShelf(_client.Delete(request)));
    }
}
