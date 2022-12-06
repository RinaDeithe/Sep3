package GRPCMethodCall;

import database.DummyData.TestItem;
import database.DummyData.TestItemType;
import GRPC.proto.File;
import GRPC.proto.SerivceGrpc;
import grpc.adapter.Item.CreateItemAdapterDB;
import grpc.adapter.ItemType.CreateItemTypeAdapterDB;
import grpc.adapter.ItemType.ReadItemTypeAdapterDB;
import grpc.adapter.Shelf.GetShelfAdapterDB;
import grpc.adapter.User.CreateUserAdapterDB;
import io.grpc.stub.StreamObserver;

//@GrpcService
public class GRPCDataBase extends SerivceGrpc.SerivceImplBase {

    @Override
    public void getShelf(File.ShelfSearchRequest dao, StreamObserver<File.ShelfProto> shelfResponds) {
        GetShelfAdapterDB shelfSelect = new GetShelfAdapterDB();
        File.ShelfProto shelfRespond = null;

        shelfRespond = shelfSelect.shelfResponse(dao);
        shelfResponds.onNext(shelfRespond);
        shelfResponds.onCompleted();
    }
/*
    @Override
    public void updateShelf(File.ShelfProto dao, StreamObserver<File.ShelfProto> shelfResponds) {
        UpdateShelfAdapterDB shelfSelect = new UpdateShelfAdapterDB();
        File.ShelfProto shelfRespond = null;

        shelfRespond = shelfSelect.shelfResponse(dao);
        shelfResponds.onNext(shelfRespond);
        shelfResponds.onCompleted();
    }
*/
    @Override
    public void createItemType(File.ItemTypeCreationRequest dto, StreamObserver<File.ItemTypeProto> itemResponds) {
        CreateItemTypeAdapterDB itemTypeAdapterDB = new CreateItemTypeAdapterDB(new TestItemType());
        File.ItemTypeProto itemTypeResponse = null;

        itemTypeResponse = itemTypeAdapterDB.CreateItemType(dto);
        itemResponds.onNext(itemTypeResponse);
        itemResponds.onCompleted();
    }



    @Override
    public void readItemType(File.ItemTypeSearchRequest dto,  StreamObserver<File.ItemTypeProto> itemTypeResponds) {
        ReadItemTypeAdapterDB itemAdapterDB = new ReadItemTypeAdapterDB();
        File.ItemTypeProto itemTypeResponse = null;

        itemTypeResponse = itemAdapterDB.readItemType(dto);
        itemTypeResponds.onNext(itemTypeResponse);
        itemTypeResponds.onCompleted();
    }
/*
    @Override
    public void readItem(File.ItemSearchRequest dto,  StreamObserver<File.ItemProto> itemResponds) {
        GetItemAdapterDB itemAdapterDB = new GetItemAdapterDB();
        File.ItemProto itemResponse = null;

        itemResponse = CreateItemTypeAdapterDB.ItemResponse(dto);
        itemResponds.onNext(itemResponse);
        itemResponds.onCompleted();
    }
*/
    @Override
    public void createItem(File.ItemCreation dto,  StreamObserver<File.ItemProto> itemResponds) {
        CreateItemAdapterDB itemAdapterDB = new CreateItemAdapterDB(new TestItem());
        File.ItemProto itemResponse = null;

        itemResponse = itemAdapterDB.CreateItemProto(dto);
        itemResponds.onNext(itemResponse);
        itemResponds.onCompleted();
    }
/*
    @Override
    public void deleteItem(File.ItemSearchRequest dao, StreamObserver<File.ItemProto> itemResponds) {
        DeleteItemAdapterDB itemAdapterDB = new DeleteItemAdapterDB();
        File.ItemProto itemResponse = null;

        itemResponse = CreateItemTypeAdapterDB.ItemResponse(dao);
        itemResponds.onNext(itemResponse);
        itemResponds.onCompleted();

    }
*/
    @Override
    public void createUser(File.CreateUserRequest dao, StreamObserver<File.UserProto> userResponse) {
        CreateUserAdapterDB createUserAdapterDB = new CreateUserAdapterDB(null);
        File.UserProto userRespond = null;


        userRespond = createUserAdapterDB.CreateUser(dao);

        userResponse.onNext(userRespond);
        userResponse.onCompleted();

    }


}