package adapter.converter.userProto;

import Domain.Model.User;
import GRPC.proto.File.*;

public class ConverterUser
{
  public static UserProto User_To_UserProto(User user)
  {
    return UserProto.newBuilder()
        .setId(user.getId())
        .build();
  }


  public static User UserProto_To_User(UserProto userProto)
  {
    return new User(userProto.getId());
  }

  public static User CreateUserRequest_To_User(CreateUserRequest newUser){
    return new User(CreateUserRequest.);
  }
}U