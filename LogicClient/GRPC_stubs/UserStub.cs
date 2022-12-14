

using ClientgRPC.ClientInterfaces;
using ClientgRPC.Converters;
using Grpc.Net.Client;
using GRPC.Proto;
using Shared.DTOs.User;
using Shared.Model;

namespace ClientgRPC.GRPC_stubs; 

public class UserStub : IUserClient {
    private GrpcChannel _channel;
    private UserService.UserServiceClient _client;
    private ConverterUser _converter;

    public UserStub() {
        _channel = GrpcChannel.ForAddress("http://localhost:9090");
        _client = new (_channel);
        _converter = new();
    }
    
    public async Task<User> Create(UserCreationDto dto) {
        CreateUserRequest request = _converter.CreationToProto(dto);

        return ConverterUser.ProtoToUser(await _client.CreateAsync(request));
    }

    public async Task<User> Read(UserSearchDto dto) {
        UserSearchRequest request = _converter.SearchToProto(dto);

        return ConverterUser.ProtoToUser(await _client.ReadAsync(request));
    }

    public async Task<List<User>> ReadAll() {
        return _converter.ProtoToList(await _client.ReadAllAsync( new emptyParams()));
    }

    public Task<User> Update(User entity) {
        throw new NotImplementedException();
    }

    public async Task<User> Delete(UserSearchDto dto) {
        UserSearchRequest request = _converter.SearchToProto(dto);

        return ConverterUser.ProtoToUser(await _client.DeleteAsync(request));
    }
}
