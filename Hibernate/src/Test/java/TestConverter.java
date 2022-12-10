import GRPC.proto.File;
import domain.Model.Item;
import domain.Model.ItemType;
import domain.Model.Shelf;
import domain.Model.User;
import grpc.converter.ItemConverter;
import grpc.converter.ItemTypeConverter;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;


public class TestConverter {

    @Test
    public void testItemToItemProto(){
        ItemType itemType = new ItemType(1,2.,3.,4.);
        User user = new User(1, "temp");
        user.setRole("tet");
        ArrayList<Item> itemList = new ArrayList<>();

        Shelf shelf = new Shelf("String rowNo", "String shelfNo", 20., 23., 24., itemList);
        Item item = new Item(itemType, user, shelf);
        itemList.add(item);

        File.ItemTypeProto itemTypeProto = ItemTypeConverter.CONVERT.toTypeProto(itemType);

        File.ItemProto itemProto= ItemConverter.CONVERT.toItemProtoFromItem(item);

        assert true;
    }
    @Test
    public void testItemTypeToItemProto(){
        ItemType itemType = new ItemType(1,2.,3.,4.);

        File.ItemTypeProto itemTypeProto = ItemTypeConverter.CONVERT.toTypeProto(itemType);

        File.ItemTypeProto test = File.ItemTypeProto.newBuilder().setId(1).setDimX(2.).setDimY(3.).setDimZ(4.).build();

        if (test.equals(itemTypeProto)){
            assert true;
        }else {
            assert false;
        }

    }
}
