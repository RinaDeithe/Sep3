package adapter.converter.ShelfProto;

import Domain.Model.Item;
import Domain.Model.ItemType;
import Domain.Model.Shelf;
import Domain.Model.User;
import grpc.converter.ShelfProto.ConverterShelf;
import grpc.converter.itemTypeProto.ConverterItemType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ConverterShelfTest
{

  @Test void name()
  {

    ArrayList<Item> ListOfItems = new ArrayList<>();

    Shelf shelf = new Shelf("2","2",2,2,2,ListOfItems);
    ItemType Dim = new ItemType(2,20.0,5.0,10.0);
    User user = new User(2);
    Item sko = new Item(Dim, 2, user, shelf);
    ListOfItems.add(sko);
    System.out.println(ConverterShelf.shelf_to_ShelfProto(shelf));


  }
  @Test
  void testAfItemType(){
    ItemType itemType = new ItemType(1,2.,4.,3.);
    System.out.println(ConverterItemType.itemType_To_ItemTypeProto(itemType));
    assertEquals(itemType,ConverterItemType.itemType_To_ItemTypeProto(itemType));
  }
}