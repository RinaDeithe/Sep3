namespace Shared.Model; 

public class Item {

    public ItemType Type { get; set; }
    public int Uid { get; set; }
    public User Owner { get; set; }
    public Shelf? Shelf { get; set; }

    public Item(ItemType type, int uid, User owner, Shelf? shelf)
    {
        Type = type;
        Uid = uid;
        Owner = owner;
        Shelf = shelf;
    }
}