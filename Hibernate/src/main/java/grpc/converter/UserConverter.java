package grpc.converter;

import GRPC.proto.File;
import domain.Model.User;

import java.util.ArrayList;
import java.util.List;

public enum UserConverter {
    CONVERT;

    public File.UserProto toUserProto(User owner) {
        if(owner==null){
            File.UserProto.newBuilder().build();
        }
        return File.UserProto.newBuilder()
                .setId(owner.getId())
                .setRole(owner.getRole())
                .build();
    }

    public User toUserFromCreation(File.CreateUserRequest request) {
        return new User(request.getIdUser(), request.getRole());
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

    public User toUserFromProto(File.UserProto owner) {
        return new User(owner.getId(), owner.getRole());
    }
}
