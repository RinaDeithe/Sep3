
/*
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
    
    public Task<User> Create(UserCreationDto dto) {
        CreateUserRequest request = _converter.CreationToProto(dto);

        return Task.FromResult(_converter.ProtoToUser(_client.Create(request)));
    }

    public Task<User> Read(UserSearchDto dto) {
        UserSearchRequest request = _converter.SearchToProto(dto);

        return Task.FromResult(_converter.ProtoToUser(_client.Read(request)));
    }

    public Task<List<User>> ReadAll() {
        return Task.FromResult(_converter.ProtoToList(_client.ReadAll(new emptyParams())));
    }

    public Task<User> Update(User entity) {
        throw new NotImplementedException();
    }

    public Task<User> Delete(UserSearchDto dto) {
        UserSearchRequest request = _converter.SearchToProto(dto);

        return Task.FromResult(_converter.ProtoToUser(_client.Delete(request)));
    }
}
*/