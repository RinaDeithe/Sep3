package grpc.converter;

import GRPC.proto.File;
import domain.Model.Item;
import domain.Model.Shelf;

import java.util.ArrayList;
import java.util.List;

public enum ShelfConverter {
    CONVERT;

    public File.ShelfProto toShelfProto(Shelf shelf) {
        return File.ShelfProto.newBuilder()
                .setRowNo(shelf.getRowNo())
                .setShelfNo(shelf.getShelfNo())
                .setShelfDimX(shelf.getDimX())
                .setShelfDimY(shelf.getDimY())
                .setShelfDimZ(shelf.getDimZ())
                .setItemsOnShelf(ItemConverter.CONVERT.toItemProtoFromList(shelf.getItemsOnShelf()))
                .build();
    }

    public Shelf toShelfFromCreation(File.ShelfCreationRequest request) {
        return new Shelf(request.getRowNo(), request.getShelfNo(), request.getShelfDimX(), request.getShelfDimY(), request.getShelfDimZ(), null);
    }

    public Shelf toShelfFromSearch(File.ShelfSearchRequest request) {
        return new Shelf("" + request.getId(), null, 0, 0, 0, null);
    }

    public File.ShelvesListProto toShelfProtoFromList(List<Shelf> shelfList) {

        File.ShelvesListProto.Builder builder = File.ShelvesListProto.newBuilder();

        List<File.ShelfProto> protoList = new ArrayList<>();

        for (Shelf index : shelfList) {
            protoList.add(File.ShelfProto.newBuilder()
                    .setItemsOnShelf(ItemConverter.CONVERT.toItemProtoFromList(index.getItemsOnShelf()))
                    .setShelfNo(index.getShelfNo())
                    .setRowNo(index.getRowNo())
                    .setShelfDimX(index.getDimX())
                    .setShelfDimY(index.getDimY())
                    .setShelfDimZ(index.getDimZ())
                    .build());
        }

        builder.addAllProto(protoList);


        return builder.build();
    }
}
