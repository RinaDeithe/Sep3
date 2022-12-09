package grpc.services;

import GRPC.proto.File;
import GRPC.proto.UserServiceGrpc;
import database.daoInterfaces.IDbDao;
import domain.Model.User;
import grpc.converter.UserConverter;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class GrpcUserService extends UserServiceGrpc.UserServiceImplBase {

    IDbDao<User> dao;

    public GrpcUserService(IDbDao<User> userDbDao) {
        dao = userDbDao;
    }

    @Override
    public void create(File.CreateUserRequest request, StreamObserver<File.UserProto> responseObserver) {
        User user = dao.Create(UserConverter.CONVERT.toUserFromCreation(request));

        File.UserProto proto = UserConverter.CONVERT.toUserProto(user);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void read(File.UserSearchRequest request, StreamObserver<File.UserProto> responseObserver) {
        User user = dao.Read(new User(), request.getId());

        File.UserProto proto = UserConverter.CONVERT.toUserProto(user);

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void readAll(File.emptyParams request, StreamObserver<File.UserListProto> responseObserver) {
        List<User> userList = dao.ReadAll(new User());

        File.UserListProto proto = UserConverter.CONVERT.toUserProtoFromList(userList);
    }

    @Override
    public void update(File.UserProto request, StreamObserver<File.UserProto> responseObserver) {
        File.UserProto proto = UserConverter.CONVERT.toUserProto(dao.Update(UserConverter.CONVERT.toUserFromProto(request)));

        responseObserver.onNext(proto);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(File.UserSearchRequest request, StreamObserver<File.UserProto> responseObserver) {
        super.delete(request, responseObserver);
    }
}
