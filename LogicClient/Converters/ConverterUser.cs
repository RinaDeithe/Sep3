using GRPC.Proto;
using Shared.Model;

namespace ClientgRPC.Converters;

public class ConverterUser
{
    public static User UserProtoToUser(UserProto userProto)
    {
        User user = new (userProto.Id, null);
        
        return user;
    }

    public static UserProto UserToUserProto(User user)
    {
        return new UserProto {Id = user.Id};
    }
}