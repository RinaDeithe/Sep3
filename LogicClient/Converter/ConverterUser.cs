using GRPC.Proto;
using Shared.Model;

namespace ClientgRPC.Converter;

public class ConverterUser
{
    public static User UserProtoToUser(UserProto userProto)
    {
        User user = new User();
        user.Id = userProto.Id;
        
        return user;
    }

    public static UserProto UserToUserProto(User user)
    {
        return new UserProto {Id = user.Id};
    }
}