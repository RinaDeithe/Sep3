package grpc.adapter.User;

import GRPC.proto.File;
import grpc.converter.userProto.ConverterUser;
import database.daoInterfaces.IUserDao;
import domain.Model.User;

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