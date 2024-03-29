package grpc.converter;

import GRPC.proto.File;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;
import grpc.services.GrpcItemService;

import java.util.ArrayList;
import java.util.List;

public enum ItemConverter {

    CONVERT;


    public Item toItemFromCreation(File.ItemCreation request) {
        return new Item(new ItemType(request.getItemTypeID(), -1., -1., -1.), new User(request.getOwnerID(), "temp"), new Shelf(request.getShelfID() + "", request.getShelfID() + "" , 0, 0, 0, new ArrayList<Item>()));
    }
    public Item toItemFromCreation(File.ItemCreation request, Shelf shelf) {
        return new Item(new ItemType(request.getItemTypeID(), -1., -1., -1.), new User(request.getOwnerID(), "temp"), shelf);
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

    private List<Item> GetItemsOnShelfList(File.ItemListProto itemsOnShelf) {

        List<Item> itemList = new ArrayList<>();
        List<Item> placeHolderList = new ArrayList<>();

        for (File.ItemProto index : itemsOnShelf.getListList()) {
            new Item(
                    index.getUniqueID(),
                    ItemTypeConverter.CONVERT.toTypeFromProto(index.getType()),
                    UserConverter.CONVERT.toUserFromProto(index.getOwner()),
                    new Shelf(
                            index.getShelf().getRowNo(),
                            index.getShelf().getShelfNo(),
                            index.getShelf().getShelfDimX(),
                            index.getShelf().getShelfDimY(),
                            index.getShelf().getShelfDimZ(),
                            placeHolderList
                    )
            );
        }


        return itemList;
    }
}
