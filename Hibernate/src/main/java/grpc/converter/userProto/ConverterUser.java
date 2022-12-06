package grpc.converter.userProto;

import GRPC.proto.File.*;
import domain.Model.User;

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

  /*
  public static User CreateUserRequest_To_User(CreateUserRequest newUser){
    return new User(CreateUserRequest.);
  }

   */
}