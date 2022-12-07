package grpc.converter;

import GRPC.proto.File;
import domain.Model.Item;
import domain.Model.User;

import java.util.ArrayList;
import java.util.List;

public enum UserConverter {
    CONVERT;

    public File.UserProto toUserProto(User owner) {
        return File.UserProto.newBuilder()
                .setId(owner.getId())
                .setRole(owner.getRole())
                .build();
    }

    public User toUserFromProto(File.CreateUserRequest request) {
        return new User(request.getIdUser());
    }

    public File.UserListProto toUserProtoFromList(List<User> userList) {

        File.UserListProto.Builder builder = File.UserListProto.newBuilder();

        List<File.UserProto> protoList = new ArrayList<>();

        for (User index : userList) {
            protoList.add(File.UserProto.newBuilder()
                    .setId(index.getId())
                    .build());
        }

        builder.addAllList(protoList);


        return builder.build();
    }
}