package grpc.services;

import GRPC.proto.File;
import GRPC.proto.UserServiceGrpc;
import database.daoInterfaces.IDbDao;
import database.daos.DbDao;
import domain.Model.User;
import grpc.converter.UserConverter;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class GrpcUserService extends UserServiceGrpc.UserServiceImplBase {

    IDbDao<User> dao;

    public GrpcUserService(DbDao<User> userDbDao) {
        dao = userDbDao;
    }

    @Override
    public void create(File.CreateUserRequest request, StreamObserver<File.UserProto> responseObserver) {
        User user = dao.Create(UserConverter.CONVERT.toUserFromProto(request));

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
    public void delete(File.UserSearchRequest request, StreamObserver<File.UserProto> responseObserver) {
        super.delete(request, responseObserver);
    }
}
