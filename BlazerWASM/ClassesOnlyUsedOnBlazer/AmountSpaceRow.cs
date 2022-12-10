namespace BlazerWASM.ClassesOnlyUsedOnBlazer;

public class AmountSpaceRow
{
    public int Amount { get; set; }
    public int AvalibleSpace { get; set; }
    public String ShelfID { get; set; }

    public AmountSpaceRow(int amount, int spaceAmount, string row)
    {
        Amount = amount;
        AvalibleSpace = spaceAmount;
        this.ShelfID = row;
    }
}