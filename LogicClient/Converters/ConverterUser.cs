using GRPC.Proto;
using Shared.DTOs.User;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterUser
{
    
    public static UserProto UserToUserProto(User user)
    {
        return new UserProto {Id = user.Id};
    }

    public CreateUserRequest CreationToProto(UserCreationDto dto) {
        return new CreateUserRequest {
            IdUser = dto.id,
            Role = "temp"
        };
    }

    public static User ProtoToUser(UserProto proto) {
        return new User(proto.Id, proto.Role);
    }

    public UserSearchRequest SearchToProto(UserSearchDto dto) {
        return new UserSearchRequest {
            Id = dto.Id,
            Role = "temp"
        };
    }

    public List<User> ProtoToList(UserListProto proto) {
        List<User> returnList = new();

        foreach (var index in proto.List) {
            returnList.Add(ProtoToUser(index));
        }

        return returnList;
    }
    
}