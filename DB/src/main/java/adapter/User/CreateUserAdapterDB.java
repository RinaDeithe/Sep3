package adapter.User;

import Domain.Model.User;
import GRPC.proto.File;
import adapter.converter.userProto.ConverterUser;
import database.DaoInterface.IUserDao;

public class CreateUserAdapterDB
{
    private IUserDao UserDao;

    public CreateUserAdapterDB(IUserDao UserDao) {
        this.UserDao = UserDao;
    }

    public File.UserProto CreateUser(File.CreateUserRequest userProto){
        User user = ConverterUser.CreateUserRequest_To_User(userProto);

        User result = UserDao.CreateUser(user);

        return ConverterUser.User_To_UserProto(result);
    }


}
