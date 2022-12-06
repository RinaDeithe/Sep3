package grpc;

import GRPC.proto.File;

public interface IGRPCDataBase {
    /*ShelfProto*/
    File.ShelfProto ReadShelf(File.ShelfSearchRequest dao);
    File.ShelfProto UpdateShelf(File.ShelfProto dao);

    
    File.ItemTypeProto CreateItemType(File.ItemTypeCreationRequest dao);
    File.ItemTypeProto ReadItem(File.ItemTypeSearchRequest dao);


    File.ItemProto CreateItem(File.ItemCreation dao);
    File.ItemProto ReadItem(File.ItemSearchRequest dao);
    File.ItemProto DeleteItem(File.ItemSearchRequest dao);


    File.UserProto CreateUser(File.UserProto dao);



}
