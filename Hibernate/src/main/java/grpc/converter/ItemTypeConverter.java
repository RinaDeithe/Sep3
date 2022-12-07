package grpc.converter;

import GRPC.proto.File;
import domain.Model.Item;
import domain.Model.ItemType;

import java.util.ArrayList;
import java.util.List;

public enum ItemTypeConverter {
    CONVERT;

    public File.ItemTypeProto toTypeProto(ItemType type) {
        return File.ItemTypeProto.newBuilder()
                .setId(type.getId())
                .setDimX(type.getDimX())
                .setDimY(type.getDimY())
                .setDimZ(type.getDimZ())
                .build();
    }

    public ItemType toTypeFromSearch(File.ItemTypeCreationRequest request) {
        return new ItemType(request.getId(), request.getItemDimX(), request.getItemDimY(), request.getItemDimZ());
    }

    public File.ItemTypeProto toTypeProtoFromType(ItemType type) {
        return File.ItemTypeProto.newBuilder()
                .setId(type.getId())
                .setDimX(type.getDimX())
                .setDimY(type.getDimY())
                .setDimZ(type.getDimZ())
                .build();
    }

    public File.ItemTypeListProto toTypeProtoFromList(List<ItemType> typeList) {

        File.ItemTypeListProto.Builder builder = File.ItemTypeListProto.newBuilder();

        List<File.ItemTypeProto> protoList = new ArrayList<>();

        for (ItemType index : typeList) {
            protoList.add(File.ItemTypeProto.newBuilder()
                    .setId(index.getId())
                    .setDimX(index.getDimX())
                    .setDimY(index.getDimY())
                    .setDimZ(index.getDimZ())
                    .build());
        }

        builder.addAllList(protoList);


        return builder.build();
    }

    public ItemType toTypeFromSearch(File.ItemTypeSearchRequest request) {
        return new ItemType(request.getId(), null, null, null);
    }
}
