namespace Shared.Model; 

public class Item {

    public ItemType Type { get; set; }
    public string Uid { get; set; }
    public User Owner { get; set; }
    public Shelf? Shelf { get; set; }

    public Item(ItemType type, string uid, User owner, Shelf? shelf)
    {
        Type = type;
        Uid = uid;
        Owner = owner;
        Shelf = shelf;
    }
}