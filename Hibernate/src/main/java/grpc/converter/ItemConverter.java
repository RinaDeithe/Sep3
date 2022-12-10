package grpc.converter;

import GRPC.proto.File;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;

import java.util.ArrayList;
import java.util.List;

public enum ItemConverter {

    CONVERT;

    public Item toItemFromCreation(File.ItemCreation request) {
        return new Item(new ItemType(request.getItemTypeID(), null, null, null), new User(request.getOwnerID(), "temp"), new Shelf(request.getShelfID() + "", request.getShelfID() + "" , 0, 0, 0, null));
    }

    public File.ItemProto toItemProtoFromItem(Item item) {
        return File.ItemProto.newBuilder()
                .setOwner(UserConverter.CONVERT.toUserProto(item.getOwner()))
                .setShelf(ShelfConverter.CONVERT.toShelfProto(item.getShelf()))
                .setUniqueID(item.getUID())
                .setType(ItemTypeConverter.CONVERT.toTypeProto(item.getType()))
                .build();
    }

    public File.ItemListProto toProtoFromList(List<Item> itemList) {


        File.ItemListProto.Builder builder = File.ItemListProto.newBuilder();
        if (itemList==null){
            return builder.build();
        }
        List<File.ItemProto> protoList = new ArrayList<>();
        System.out.println(itemList.isEmpty());
        for (Item index : itemList) {
            protoList.add(File.ItemProto.newBuilder()
                    .setOwner(UserConverter.CONVERT.toUserProto(index.getOwner()))
                    .setShelf(
                            File.ShelfProto.newBuilder().setRowNo(index.getShelf().getRowNo())
                                    .setShelfNo(index.getShelf().getShelfNo())
                                    .setShelfDimZ(index.getShelf().getDimZ())
                                    .setShelfDimY(index.getShelf().getDimY())
                                    .setShelfDimX(index.getShelf().getDimX())
                                    .build()
                    )
                    .setUniqueID(index.getUID())
                    .setType(ItemTypeConverter.CONVERT.toTypeProto(index.getType()))
                    .build());
        }

        builder.addAllList(protoList);


        return builder.build();
    }

    public Item toItemFromProto(File.ItemProto request) {

        return new Item(request.getUniqueID(), ItemTypeConverter.CONVERT.toTypeFromProto(request.getType()), UserConverter.CONVERT.toUserFromProto(request.getOwner()), ShelfConverter.CONVERT.toShelfFromProto(request.getShelf()));

    }
}
