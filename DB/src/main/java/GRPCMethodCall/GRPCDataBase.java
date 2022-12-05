
package GRPCMethodCall;

import Domain.Model.User;

import DummyData.TestItem;
import DummyData.TestItemType;
import GRPC.proto.File;
import GRPC.proto.SerivceGrpc;
import adapter.Item.CreateItemAdapterDB;
import adapter.ItemType.CreateItemTypeAdapterDB;
import adapter.ItemType.ReadItemTypeAdapterDB;
import adapter.Shelf.GetShelfAdapterDB;
import adapter.Shelf.UpdateShelfAdapterDB;
import adapter.User.CreateUserAdapterDB;
import database.DAOs.UserDao;
import io.grpc.stub.StreamObserver;
//import net.devh.boot.grpc.server.service.GrpcService;

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